import br.com.amedigital.controller.PlanetController;
import br.com.amedigital.model.Results;

import java.util.List;

public class PlanetControllerTest {

    public static void main(String[] args) {
        PlanetController teste = new PlanetController();
        List<Results> results = teste.allPlanetApiStarWars();
    }
}
