package digital.equinox.springcore.views.vaadin

import com.flowingcode.vaadin.addons.googlemaps.GoogleMap
import com.flowingcode.vaadin.addons.googlemaps.GoogleMapPoint
import com.flowingcode.vaadin.addons.googlemaps.GoogleMapPolygon
import com.flowingcode.vaadin.addons.googlemaps.LatLon
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import digital.equinox.springcore.Const.URL_SEPARATOR
import digital.equinox.springcore.Const.Url.VaadinRoute.googleMapsVaadinUrl
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import java.util.*

@PageTitle(googleMapsVaadinUrl)
@Route(value = URL_SEPARATOR + googleMapsVaadinUrl)
class GoogleMapsView : VerticalLayout() {

	@Value("\${app.vaadin.googleMapApiKey}")
	private lateinit var googleMapApiKey: String

	@PostConstruct
	fun postConstruct() {

		val gmaps = GoogleMap(googleMapApiKey, "", "")
		gmaps.mapType = GoogleMap.MapType.SATELLITE
		gmaps.setSizeFull()
		gmaps.center = LatLon(0.0, 0.0)
		gmaps.addMarker("Center", LatLon(0.0, 0.0), true, "")
		val gmp: GoogleMapPolygon = gmaps.addPolygon(
			listOf(
				GoogleMapPoint(gmaps.center),
				GoogleMapPoint(gmaps.center.lat, gmaps.center.lon + 1),
				GoogleMapPoint(gmaps.center.lat + 1, gmaps.center.lon)
			)
		)
		add(gmaps)

		val header = H2("GoogleMaps page")
		add(header)
		setSizeFull()
		justifyContentMode = FlexComponent.JustifyContentMode.CENTER
		defaultHorizontalComponentAlignment = FlexComponent.Alignment.CENTER
		style["text-align"] = "center"
	}
}