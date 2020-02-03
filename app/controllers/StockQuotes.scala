package controllers

import javax.inject._
import play.api.mvc._
import play.api.i18n._
import yahoofinance.YahooFinance
import yahoofinance.Stock
import java.util

@Singleton
class StockQuotes @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def stockQuotes = Action {
    val stockListings = List("INTC", "BABA", "TSLA", "AIR.PA", "YHOO")
    Ok(views.html.stockQuotes(stockListings))
  }

  def singleStock(stockListing: String) = Action {

    val stock = YahooFinance.get(stockListing)
    val symbol = stock.getSymbol
    val price = stock.getQuote.getPrice
    val change = stock.getQuote.getChangeInPercent
    val peg = stock.getStats.getPeg
    val dividend = stock.getDividend.getAnnualYieldPercent
    stock.print()
    Ok("Your stock listing is: " + symbol + "\n" +
      "Your price is: " + price + "\n" +
    "Your percent change is: " + change + "\n" +
      "Your price/earnings to growth ratio is: " + peg + "\n" +
    "Your dividend is: " + dividend + "\n")
  }

  def multipleStocks(stockListings: String) = Action {
    val symbols = Array[String](stockListings)
    val stocks = YahooFinance.get(symbols) // single request
    Ok("" + stocks)
  }
}
