var settings = {
	"async": true,
	"crossDomain": true,
	"url": "https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-chart?interval=5m&region=US&symbol=AMRN&lang=en&range=1d",
	"method": "GET",
	"headers": {
		"x-rapidapi-host": "apidojo-yahoo-finance-v1.p.rapidapi.com",
		"x-rapidapi-key": "61d2531612mshe28820d2fe43ca9p107befjsnc64077844eb2"
	}
}

$.ajax(settings).done(function (response) {
	console.log(response);
});