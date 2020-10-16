package open.space.consumer.messaging.messages

data class NewsMessage(
    val text: String
)


/*
{
    "data" : {
        "text" : "message for the world",
        }
}



 "bindings": [
    {
      "source": "news_exchange",
      "vhost": "/",
      "destination": "news-italy-veneto",
      "destination_type": "queue",
      "routing_key": "news",
      "arguments": {}
    },
    {
      "source": "news_exchange",
      "vhost": "/",
      "destination": "news-germany-berlin",
      "destination_type": "queue",
      "routing_key": "news",
      "arguments": {}
    },
    {
      "source": "news_exchange",
      "vhost": "/",
      "destination": "news-italy-veneto",
      "destination_type": "queue",
      "routing_key": "news.italy.#",
      "arguments": {}
    },
    {
      "source": "news_exchange",
      "vhost": "/",
      "destination": "news-italy-veneto",
      "destination_type": "queue",
      "routing_key": "news.italy.veneto",
      "arguments": {}
    },
    {
      "source": "news_exchange",
      "vhost": "/",
      "destination": "news-germany-berlin",
      "destination_type": "queue",
      "routing_key": "news.germany.berlin",
      "arguments": {}
    },
    {
      "source": "news_exchange",
      "vhost": "/",
      "destination": "news-germany-berlin",
      "destination_type": "queue",
      "routing_key": "news.germany.#",
      "arguments": {}
    },
    {
      "source": "dead_letters_exchange",
      "vhost": "/",
      "destination": "news.dead",
      "destination_type": "queue",
      "routing_key": "news.dead",
      "arguments": {}
    }
  ]
* */