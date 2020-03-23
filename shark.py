class Shark:
    def _init_(self, name):
        self.name = name
        # Initiates the object with a name

    def swim(self):
        print(self.name + " is swimming.")
        # Says that the shark is swimming

    def be_awesome(self):
        print(self.name + " is being awesome.")
        # Says that the shark is being awesome

def main():
    sammy = Shark("Sammy")
    sammy.be_awesome()
    stevie = Shark("Stevie")
    stevie.swim()
    robert = Shark("Robert")
    robert.be_awesome()
    # Has the program create three sharks of the
    # given names and then runs a method for each

if __name__ == "__main__":
    main()
    # Gives the condition that runs the main()???
