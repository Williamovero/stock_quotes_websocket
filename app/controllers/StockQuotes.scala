package controllers

import javax.inject._
import play.api.mvc._
import play.api.i18n._
import yahoofinance.YahooFinance


@Singleton
class StockQuotes @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def stockQuotes = Action {
    val stockListings = List("INTC", "BABA", "TSLA", "AIR.PA", "YHOO")
    Ok(views.html.stockQuotes(stockListings))
  }

  def singleStock(stockListing: String) = Action {

    val stock = YahooFinance.get("INTC")
    val price = stock.getQuote.getPrice
    val change = stock.getQuote.getChangeInPercent
    val peg = stock.getStats.getPeg
    val dividend = stock.getDividend.getAnnualYieldPercent
    stock.print()
    Ok(s"Your single stock listing is: $stockListing")
  }
}
