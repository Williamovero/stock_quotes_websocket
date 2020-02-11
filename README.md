# Stock Quotes Websocket
A web app that connects to Yahoo Finance using the Scala Play Framework.

[![Build Status](http://img.shields.io/travis/badges/badgerbadgerbadger.svg?style=flat-square)](https://travis-ci.org/badges/badgerbadgerbadger)

## Getting Started

### SetUp
```shell
In your terminal type:  
$ sbt run
In your browser type: 
http://localhost:9000/
http://localhost:9000/stock_quotes/single_stock?stockListing=single stock 
eg. http://localhost:9000/stock_quotes/single_stock?stockListing=FB
http://localhost:9000/stock_quotes/multiple_stocks?stockListings=multiple stock symbols delimited by "," 
eg. http://localhost:9000/stock_quotes/multiple_stocks?stockListings=BABA,MSFT,AAPL
```
### Prerequisites

```
Java SE 1.8 or higher
sbt
```

## Built With

* [Play](https://www.playframework.com/) - The web framework used
* [sbt](https://scala-lang.org) - Dependency Management
* [Yahoo Finance Api](https://financequotes-api.com/) - API to connect to Yahoo Finance
* [MDBootstrap](https://mdbootstrap.com/) - Ui development

## Contributing

Please read [CONTRIBUTING.md](https://github.com/Williamovero/stock_quotes_websocket/graphs/contributors) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* **William Orgertrice** - *Initial work* - [stock_quotes_websocket](https://github.com/Williamovero/stock_quotes_websocket)

See also the list of [contributors](https://github.com/Williamovero/stock_quotes_websocket/graphs/contributors) 

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments


* [Yahoo Finance Api](https://financequotes-api.com/)

