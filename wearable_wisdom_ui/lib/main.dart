import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wearable_wisdom_ui/constants/watch_string_constants.dart';
import 'package:wearable_wisdom_ui/providers/quote_provider.dart';
import 'package:wearable_wisdom_ui/screens/quote_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [ChangeNotifierProvider(create: (context) => QuoteProvider())],
      child: MaterialApp(
        title: WatchStringConstants.appName,
        theme: ThemeData(
          colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        ),
        home: QuoteScreen(),
      ),
    );
  }
}
