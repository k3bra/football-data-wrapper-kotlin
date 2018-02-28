import java.net.URL
import java.time.LocalDate
import java.io.BufferedReader
import java.io.InputStreamReader


class FootballDataWrapper(
        private val apiKey: String = ""
) {

    private val url: String = "https://www.football-data.org/v1/"

    private fun getResponse(url: String): String {
        val myURL = URL(url)

        myURL.openConnection().setRequestProperty("X-Auth-Token", this.apiKey)
        myURL.openConnection().setRequestProperty("X-Response-Control", "full")

        val buffer = BufferedReader(InputStreamReader(
                myURL.openConnection().getInputStream()))

        return buffer.readText()
    }

    fun getFixtureFrom(from: String, to: String): String {
        return this.getResponse(url + "fixtures?timeFrameStart=$from&timeFrameEnd=$to")
    }

    fun getTodayFixtures(): String {
        val todayDate = LocalDate.now()
        return getResponse(url + "fixtures?timeFrameStart=$todayDate&timeFrameEnd=$todayDate")
    }

    fun getCompetitionTable(id: Int, matchDay: Int): String {
        return getResponse(url + "competitions/$id/leagueTable/?matchday=$matchDay")
    }

    fun getCompetitions(year: Int): String {
        return getResponse(url + "competitions/?season=$year")
    }

    fun getAllCompetions(): String {
        return getResponse(url + "competitions")
    }

    fun getCompetitionTeams(id: Int): String {
        return getResponse(url + "competitions/$id/teams")
    }

    fun getLeagueFixtures(id: Int, matchDay: Int, timeFrame: String): String {
        return getResponse(url + "competitions/$id/fixtures/?matchday=$matchDay&timeFrame=$timeFrame")
    }

    fun getFixture(id: Int, head: String): String {
        return getResponse(url + "fixtures/$id/?head2head=$head")
    }

    fun getFixturesOfSet(leagueCode: String = "", timeFrame: String = ""): String {
        return getResponse(url + "fixtures/?leagueCode=$leagueCode&timeFrame=$timeFrame")
    }

    fun getTeamFixtures(id: Int, season: String = "", timeFrame: String = "", venue: String = ""): String {
        return getResponse(url + "teams/$id/fixtures/?season=$season&timeFrame=$timeFrame&venue=$venue")
    }

    fun getTeam(id: Int): String {
        return getResponse(url + "teams/$id")
    }

    fun getTeamPlayers(id: Int): String {
        return getResponse(url + "teams/$id/players")
    }
}