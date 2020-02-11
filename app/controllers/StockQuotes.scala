package controllers

import javax.inject._
import play.api.mvc._
import yahoofinance.{Stock, YahooFinance}
import play.api.data._
import play.api.data.Forms._

@Singleton
class StockQuotes @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def priceInDollars(stock: Stock): String ={
    stock.getQuote.getPrice.toString.patch(0,"$",0)
  }

  def getStockInformation(stock: Stock): Array[String] ={
    val change = stock.getQuote.getChangeInPercent.toString
    val dividend = stock.getDividend.toString
    val stockStats = stock.getStats.toString.split(",")
    val changeDividend = Array[String](change,dividend)
    val stockInformation = stockStats ++ changeDividend
    stockInformation
  }

  def singleStock(stockListing: String) = Action {

    val stock = YahooFinance.get(stockListing)
    val symbol = stock.getSymbol
    val price = priceInDollars(stock)
    val stockName = stock.getName
    val stockInformation = getStockInformation(stock)
    Ok(views.html.singleStockQuote(stockName,symbol.toString,price,stockInformation))
  }

  def multipleStocks(stockListings: String) = Action {
    val symbols = Array[String](stockListings)
    val stocks = YahooFinance.get(symbols).toString.split(",") // single request
    Ok(views.html.stockQuotes(stocks))
  }
}
