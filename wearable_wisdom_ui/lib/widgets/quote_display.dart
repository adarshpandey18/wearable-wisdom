import 'package:flutter/material.dart';
import 'package:wearable_wisdom_ui/models/quote.dart';

class QuoteDisplay extends StatelessWidget {
  final Quote quote;
  final VoidCallback onPress;

  const QuoteDisplay({super.key, required this.quote, required this.onPress});

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: SingleChildScrollView(
        padding: const EdgeInsets.symmetric(horizontal: 10.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.format_quote_rounded, size: 30, color: Colors.white38),
            const SizedBox(height: 10),
            Text(
              '"${quote.quote}"',
              textAlign: TextAlign.center,
              style: const TextStyle(
                fontSize: 18,
                fontStyle: FontStyle.italic,
                color: Colors.white,
              ),
            ),
            const SizedBox(height: 5),
            Text(
              '- ${quote.author}',
              style: const TextStyle(
                fontSize: 12,
                fontWeight: FontWeight.w500,
                color: Colors.white70,
              ),
            ),
            const SizedBox(height: 8),
            IconButton(
              onPressed: onPress,
              icon: const Icon(Icons.change_circle, color: Colors.white),
            ),
          ],
        ),
      ),
    );
  }
}
