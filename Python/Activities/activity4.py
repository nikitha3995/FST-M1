user1 = input("enter the user1 value:").lower()
user2 = input("enter the user2 value:").lower()

play = input("do you wanna play?? say yes or no").lower()

if play == "yes":
    if user1 == "rock":
        if user2 == "scissors":
            print("rock wins")
        else:
            print("paper win")

    elif user1 == "scissors":
        if user2 == "paper":
            print("scissors wins")
        else:
            print("rock win")

    elif user1 == "paper":
        if user2 == "rock":
            print("paper wins")
        else:
            print("scissors win")

    elif user1 == user2:
        print("its a tie")

    else:
        print("invalid input")

elif play == "no":
    raise SystemExit
