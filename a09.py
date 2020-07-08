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
    #inherits __init__ function

# Cannot find a way to get the values out of the generator self.sides to use them in my
# equations below. Any ideas on how I can do that without modifying the give code above?
    def findArea(self):
        print ("Computing Triangle's Area")
        # Find semi_perimeter, which is all sides added, divided by 2.
        semi_perimeter = ((semi_perimeter + next(self.sides)) for i in range(self.n))
        # triangle_area = sqrt(semi_perimeter * (s_p - s1)(s_p - s2)(s_p - s3))

print("Program by Robert Pratt\n")
t = Triangle(3)
t.inputSides()
t.dispSides()
t.findArea()
