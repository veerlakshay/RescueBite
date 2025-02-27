import os
from dotenv import load_dotenv
import requests
import pandas as pd

# Load environment variables from .env file
load_dotenv()

# Get the API key from the environment
API_KEY = os.getenv("ALPHA_VANTAGE_API_KEY")

def fetch_stock_data(symbol):
    # API endpoint for daily stock data
    url = f"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol={symbol}&apikey={API_KEY}"
    
    # Make the API request
    response = requests.get(url)
    
    # Check if the request was successful
    if response.status_code != 200:
        raise Exception(f"API request failed with status code {response.status_code}")
    
    # Parse the JSON response
    data = response.json()
    
    # Check if the API returned an error message
    if "Error Message" in data:
        raise Exception(f"API Error: {data['Error Message']}")
    
    # Extract the time series data
    time_series = data.get("Time Series (Daily)", {})
    
    # Check if time_series is empty
    if not time_series:
        raise Exception(f"No data found for symbol: {symbol}")
    
    # Convert the data into a pandas DataFrame
    df = pd.DataFrame(time_series).T
    df.index = pd.to_datetime(df.index)
    df = df.astype(float)
    df.columns = ["Open", "High", "Low", "Close", "Volume"]
    
    return df

# Example: Fetch data for Apple (AAPL)
symbol = "AAPL"
try:
    stock_data = fetch_stock_data(symbol)
    print(stock_data.head())
except Exception as e:
    print(f"Error: {e}")