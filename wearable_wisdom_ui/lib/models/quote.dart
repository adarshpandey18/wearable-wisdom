class Quote {
  final String quote;
  final String author;

  Quote({required this.quote, required this.author});

  factory Quote.fromJson(Map<String, dynamic> json) {
    final data = json['data'];
    if (data == null) {
      throw Exception('No quote data found');
    }
    return Quote(quote: data['quote'], author: data['author']);
  }
}
