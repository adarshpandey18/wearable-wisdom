import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wearable_wisdom_ui/constants/watch_string_constants.dart';
import 'package:wearable_wisdom_ui/providers/quote_provider.dart';
import 'package:wearable_wisdom_ui/widgets/quote_display.dart';

class QuoteScreen extends StatefulWidget {
  const QuoteScreen({super.key});

  @override
  State<QuoteScreen> createState() => _QuoteScreenState();
}

class _QuoteScreenState extends State<QuoteScreen> {
  @override
  void initState() {
    Future.microtask(
      () => Provider.of<QuoteProvider>(context, listen: false).getDailyQuote(),
    );
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    final provider = Provider.of<QuoteProvider>(context);
    final quote = provider.quote;
    final loading = provider.loading;

    return GestureDetector(
      onTap: () => provider.getDailyQuote(),
      child: Scaffold(
        backgroundColor: Colors.black,
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(20.0),
            child: loading
                ? const CircularProgressIndicator(color: Colors.white)
                : quote == null
                ? Text(
                    WatchStringConstants.noQuoteFound,
                    style: TextStyle(color: Colors.white),
                  )
                : QuoteDisplay(
                    quote: quote,
                    onPress: () => provider.getRandomQuote(),
                  ),
          ),
        ),
      ),
    );
  }
}
