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
    val price = stock.getQuote.getPrice
    val change = stock.getQuote.getChangeInPercent
    val peg = stock.getStats.getPeg
    val dividend = stock.getDividend.getAnnualYieldPercent
    stock.print()
    Ok(views.html.singleStockQuote)
  }

  def multipleStocks(stockListings: String) = Action {
    val symbols = stockListings.split(",")
    val stocks = YahooFinance.get(symbols) // single request

    val intel = stocks.get("INTC")
    val airbus = stocks.get("AIR.PA")
    Ok(symbols)
  }
}
