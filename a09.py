#IT 2819 - Python Programming
#Prof. Weisfeld
#Robert Pratt
#Assignment 09 - A09-Pratt.py

import math

class Shape:
    def __init__(self, no_of_sides):
        print ("Inside Constructor\n")
        self.n = no_of_sides
        self.sides = [0 for i in range(no_of_sides)]

    def inputSides(self):
        print ("Input Sides")
        self.sides = [float(input("Enter side "+str(i+1)+" : ")) for i in range(self.n)]
        print ("\n")

    def dispSides(self):
        print ("Display Sides")
        for i in range(self.n):
            print("Side",i+1,"is",self.sides[i])

class Triangle(Shape):
    def __init__(self, no_of_sides):
        if no_of_sides > 3:
            print ("Error: Triangles can only have 3 sides")
        else:
            Shape.__init__(self, no_of_sides)

    def findArea(self):
        print ("\nInside Triangle Constructor \n")

        self.inputSides()
        self.dispSides()

        semi_perimeter = 0
        for i in self.sides:
            semi_perimeter += i
        semi_perimeter /= 2
        side = [float(semi_perimeter - i) for i in self.sides]
        triangle_area = math.sqrt(semi_perimeter * side[0] * side[1] * side[2])
        print ("\nComputing Triangle's Area \n")
        print ("The area of this triangle is: " + format(triangle_area, '.2f'))
        

print("Program by Robert Pratt\n")
t = Triangle(3)
t.findArea()
