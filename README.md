1.) clone the project using git clone <https://github.com/akki852kr/Automation_Testing_Deck-of-cards.git>  on local machine. 
2.) Make sure u have maven install on your system.
3.) inside the project root directory open cmd and run mvn test.

// used maven dependencies

What I did in the project:
Testing is done through Rest-assured.
1. gettingNewDeck() = for testing https://deckofcardsapi.com/api/deck/new/
   get api which creates new deck
2. addingJockers() = for testing https://deckofcardsapi.com/api/deck/new/?jokers_enabled=true
   get api which adds to jockers in already created deck
3. drawingCard() = for testing https://deckofcardsapi.com/api/deck/<<deck_id>>/draw/
   get api which draws 2 cards from the already created deck 



 
