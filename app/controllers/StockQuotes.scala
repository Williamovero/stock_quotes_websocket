package controllers

import javax.inject._
import play.api.libs.ws._
import play.api.mvc._
import yahoofinance.{Stock, YahooFinance}


@Singleton
class StockQuotes @Inject()(ws: WSClient, val controllerComponents: ControllerComponents) extends BaseController {

  def priceInDollars(stock: Stock): String = {
    stock.getQuote.getPrice.toString.patch(0, "$", 0)
  }

  def getStockInformation(stock: Stock): Array[String] = {
    val change = stock.getQuote.getChangeInPercent.toString
    val dividend = stock.getDividend.toString
    val stockStats = stock.getStats.toString.split(",")
    val changeDividend = Array[String](change, dividend)
    val stockInformation = stockStats ++ changeDividend
    stockInformation
  }

  def singleStock(stockListing: String): Action[AnyContent] = Action {
    val stock = YahooFinance.get(stockListing)
    val symbol = stock.getSymbol
    val price = priceInDollars(stock)
    val stockName = stock.getName
    val stockInformation = getStockInformation(stock)
    Ok(views.html.singleStockQuote(stockName, symbol.toString, price, stockInformation))
  }

  def multipleStocks(stockListings: String): Action[AnyContent] = Action {
    val symbols = Array[String](stockListings)
    val stocks = YahooFinance.get(symbols).toString.split(",") // single request
    Ok(views.html.stockQuotes(stocks))
  }
}
