package controllers

import javax.inject._
import play.api.mvc._
import yahoofinance.YahooFinance

@Singleton
class StockQuotes @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def singleStock(stockListing: String) = Action {

    val stock = YahooFinance.get(stockListing)
    val symbol = stock.getSymbol
    val price = stock.getQuote.getPrice
    val change = stock.getQuote.getChangeInPercent
    val peg = stock.getStats.getPeg
    val dividend = stock.getDividend
    val stockListingInfo = List(price, change, peg, dividend)
    stock.print()
    Ok(views.html.singleStockQuote(symbol.toString,stockListingInfo))
  }

  def multipleStocks(stockListings: String) = Action {
    val symbols = Array[String](stockListings)
    val stocks = YahooFinance.get(symbols) // single request
    Ok(views.html.stockQuotes(stocks))
  }
}
