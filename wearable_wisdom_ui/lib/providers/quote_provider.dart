import 'package:flutter/material.dart';
import 'package:wearable_wisdom_ui/models/quote.dart';
import 'package:wearable_wisdom_ui/services/quote_service.dart';

class QuoteProvider with ChangeNotifier {
  Quote? _quote;
  bool _loading = false;

  Quote? get quote => _quote;
  bool get loading => _loading;

  QuoteService quoteService = QuoteService();

  Future<void> getDailyQuote() async {
    _loading = true;
    notifyListeners();
    try {
      _quote = await quoteService.getDailyQuote();
    } catch (e) {
      _quote = null;
      debugPrint('Provider error: $e');
    }
    _loading = false;
    notifyListeners();
  }

  Future<void> getRandomQuote() async {
    _loading = true;
    notifyListeners();
    try {
      _quote = await quoteService.getRandomQuote();
    } catch (e) {
      _quote = null;
      debugPrint('Provider error: $e');
    }
    _loading = false;
    notifyListeners();
  }
}
