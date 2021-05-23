Currency Exchange URL:
http://localhost:8000/currency-exchange/from/USD/to/INR
http://localhost:8001/currency-exchange/from/USD/to/INR

Currency Conversion Service:
http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10

Eureka:
http://localhost:8761/

Api-Gateway:
# in below first URL of the API gateway/name of the Applicationregistered with Eureka/getMapping path of the application
 http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange/from/USD/to/INR
 
 http://localhost:8765/CURRENCY-CONVERSION/currency-conversion/from/USD/to/INR/quantity/10