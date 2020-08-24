import simulation.BasicSimulation
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object Engine extends App {

	val props = new GatlingPropertiesBuilder()
		.resourcesDirectory(IDEPathHelper.mavenResourcesDirectory.toString)
		.resultsDirectory(IDEPathHelper.resultsDirectory.toString)
		.binariesDirectory(IDEPathHelper.mavenBinariesDirectory.toString)
		.simulationClass(classOf[BasicSimulation].getName)

	Gatling.fromMap(props.build)
}
