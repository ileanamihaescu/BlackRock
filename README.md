# BlackRock
We have developed some programmes in order to solve our tasks:

Apy.py 	- it's a phyton script that takes png faxes from the site and saves them into a folder. Then iterate through every fax and send a request to
	Google Vision API.(This API permitted us sending a limited number of requests and as a result we have tried out application on a smaller input).
	The response to every picture request was displayed into a separate file.(the selection of keywords was made in java)

BLK 	- we created a database with informations about the clients, funds, transactions and then we connected it with our java project.
	 Usig JPA and the RMI method, we managed to transfer the data from the client to the server and then to the database.
	 The data from the phyton script was selected and introduced to an output file that we used for our database.

HackSociety - it's a PhoneGap application that consists of html, css and js files in order to display all the information extracted in the above programmes.
	We have tried to make a Homepage with a menu that consisted of 5 fields : about, requests, chart, statistics, help.
	The request button take the employee into the world of faxes. He can now "talk the Tinder language". If the signature is a true one then, it should be
	"match" and the fax should be introduced into the database. Else, the negative response will arrive to the one who wanted to put money in.  
	The chart and statistics buttons should display some information about the internal economy.
	
	
   
