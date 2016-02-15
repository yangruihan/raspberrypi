final_account_value = float(input('Enter the final account value: '))
interest_rate = float(input('Enter the annual interest rate: '))
number_of_years = float(input('Enter the number of years: '))
print(str(final_account_value / ((1 + interest_rate / 100) ** number_of_years)))
