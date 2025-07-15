import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:wearable_wisdom_ui/models/quote.dart';

class QuoteService {
  static const String _baseUrl = 'http://10.0.2.2:8080/wearable-wisdom/api';

  Future<Quote> getRandomQuote() async {
    final String url = '$_baseUrl/random';
    final Uri uri = Uri.parse(url);

    try {
      final response = await http.get(uri);
      print('Raw response: ${response.body}');

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        return Quote.fromJson(data);
      } else {
        throw Exception(
          'Failed to load quote. Status code: ${response.statusCode}',
        );
      }
    } catch (e) {
      print('Error fetching quote: $e');
      rethrow;
    }
  }

  Future<Quote> getDailyQuote() async {
    final String url = '$_baseUrl/daily';
    final Uri uri = Uri.parse(url);

    try {
      final response = await http.get(uri);
      print('Raw response: ${response.body}');

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        return Quote.fromJson(data);
      } else {
        throw Exception(
          'Failed to load quote. Status code: ${response.statusCode}',
        );
      }
    } catch (e) {
      print('Error fetching quote: $e');
      rethrow;
    }
  }
}
