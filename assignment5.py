temp = input("Input the  temperature you like to convert? (e.g., 45F, 102C etc.) : ")
degree = int(temp[:-1]) #all of the string except for its last character
input_type = temp[-1] #get the last character

print("You entered: ", temp)
print("The degree entry is: ", degree)
print("The degree type is: ", input_type)

# Add code here

if input_type is "c" or "C":
    output_type = "Fahrenheit"
    result = str((degree * 1.8) - 32)
elif input_type is "f" or "F":
    output_type = "Celsius"
    result = str((degree - 32) / 1.8)
else:
    print("Input proper convention")

print("The temperature in", output_type, "is", result, " degrees.")
