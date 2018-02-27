
```

	
Available methods:


```kotlin
    fun getFixtureFrom(from: String, to: String): String 
    
    fun getTodayFixtures(): String 

    fun getCompetitionTable(id: Int, matchDay: Int): String 

    fun getCompetitions(year: Int): String 

    fun getAllCompetions(): String

    fun getCompetitionTeams(id: Int): String 

    fun getLeagueFixtures(id: Int, matchDay: Int, timeFrame: String): String 

    fun getFixture(id: Int, head: String): String

    fun getFixturesOfSet(leagueCode: String = "", timeFrame: String = ""): String 

    fun getTeamFixtures(id: Int, season: String = "", timeFrame: String = "", venue: String = ""): String 

    fun getTeam(id: Int): String 

    fun getTeamPlayers(id: Int): String 
```
