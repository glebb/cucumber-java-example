Feature: Scoring Rules
	
	Scenario: Game starts from nil
		When nobody has scored
		Then score is "0-0"
		
	Scenario: Player one scores once
		When player 1 scores 1 times
		Then score is "15-0"
		
	Scenario: Player one scores twice
		When player 1 scores 2 times
		Then score is "30-0"		
		
	Scenario: Deuce
		When player 1 scores 3 times
		And player 2 scores 3 times
		Then score is "deuce"				
		
	Scenario: Player gains advantage
		When player 1 scores 3 times
		And player 2 scores 3 times
		And player 1 scores 1 times
		Then score is "adv-40"						