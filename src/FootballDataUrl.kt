import java.net.URL
import java.time.LocalDate


class FootballDataWrapper {

    private var url: String = "https://www.football-data.org/v1/"

    fun getFixtureFrom(from: String, to: String): String {
        return URL(url + "fixtures?timeFrameStart=$from&timeFrameEnd=$to").readText()
    }

    fun getTodayFixtures(): String {
        val todayDate = LocalDate.now()
        return URL(url + "fixtures?timeFrameStart=$todayDate&timeFrameEnd=$todayDate").readText()
    }

    fun getCompetitionTable(id: Int, matchDay: Int): String {
        return URL(url + "competitions/$id/leagueTable/?matchday=$matchDay").readText()
    }

    fun getCompetitions(year: Int): String {
        return URL(url + "competitions/?season=$year").readText()
    }

    fun getAllCompetions(): String {
        return URL(url + "competitions").readText()
    }

    fun getCompetitionTeams(id: Int): String {
        return URL(url + "competitions/$id/teams").readText()
    }

    fun getLeagueFixtures(id: Int, matchDay: Int, timeFrame: String): String {
        return URL(url + "competitions/$id/fixtures/?matchday=$matchDay&timeFrame=$timeFrame").readText()
    }

    fun getFixture(id: Int, head: String): String {
        return URL(url + "fixtures/$id/?head2head=$head").readText()
    }

    fun getFixturesOfSet(leagueCode: String = "", timeFrame: String = ""): String {
        return URL(url + "fixtures/?leagueCode=$leagueCode&timeFrame=$timeFrame").readText()
    }

    fun getTeamFixtures(id: Int, season: String = "", timeFrame: String = "", venue: String = ""): String {
        return URL(url + "teams/$id/fixtures/?season=$season&timeFrame=$timeFrame&venue=$venue").readText()
    }

    fun getTeam(id: Int): String {
        return URL(url + "teams/$id").readText()
    }

    fun getTeamPlayers(id: Int): String {
        return URL(url + "teams/$id/players").readText()
    }
}