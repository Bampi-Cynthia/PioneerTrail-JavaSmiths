package PioneerTrail.control;

import PioneerTrail.exceptions.MapControlException;
import PioneerTrail.model.Actor;
import PioneerTrail.model.Game;
import PioneerTrail.model.Location;
import java.awt.Point;
import PioneerTrail.model.Map;
import PioneerTrail.model.Question;
import PioneerTrail.model.Resource;
import PioneerTrail.model.Scene;
import PioneerTrail.model.SceneType;
import java.util.ArrayList;
import pionnertrail.PioneerTrail;

/**
 *
 * @author Cynthia Bampi
 */
public class MapControl {

    Map map = new Map();

    public String move(Point newCourse) {
        Point currentCoord = map.getCoordinates();

        if (newCourse == currentCoord) {
            return "You are already at this location";
        } else {
            map.setCoordinates(newCourse);
            return "You are now at " + newCourse;
        }
    }

    public Point getCurrentLoction() {
       // map.setCoordinates(1, 3); //testing purposes
        return map.getCoordinates();
    }

    public static Map createMap(int noOfRows, int noOfColumns) throws MapControlException{
        if (noOfRows <= 0 || noOfColumns <= 0) {
            throw new MapControlException("Error creating the map");
        };

        Map map = new Map();
        map.setRowCount(noOfRows);
        map.setColumnCount(noOfColumns);
        Location[][] locations = createLocations(noOfRows, noOfColumns);
        map.setLocations(locations);
        Scene[] scenes = createScenes();
        //Question[] questions = createQuestions();
        //assignQuestionsToScenes(questions, scenes);
        //assignItemsToScenes(scenes);
        assignScenesToLocations(scenes, locations);

        System.out.println("You have called the createMap method");
        return map;
    }

    public static Location[][] createLocations(int noOfRows, int noOfColumns) throws MapControlException{
        System.out.println("Create Locations called");

        if (noOfRows < 1 || noOfColumns < 1) {
            throw new  MapControlException();
        }
        Location[][] locations = new Location[noOfRows][noOfColumns];
        //NAVIGATE A TWO DIMENSIONAL ARRAY

        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfColumns; col++) {
                locations[row][col] = new Location();
            }
        }
        return locations;
    }

    public static Scene[] createScenes() {
        Scene[] scenes = new Scene[25];

//Scene 1 NAUVOO
        scenes[SceneType.Nauvoo.ordinal()] = new Scene();

        scenes[SceneType.Nauvoo.ordinal()].setDescription("It is a lovely city in the Mississipi river in the state of Illinois");
        scenes[SceneType.Nauvoo.ordinal()].setName("Nauvoo");
        scenes[SceneType.Nauvoo.ordinal()].setSymbol("NV");
        Question question = new Question();
        question.setQuestion("What river do we need to cross when we leave Navoo?");
        question.setAnswer1("Salt Lake River");
        question.setAnswer2("Silver River");
        question.setAnswer3("Mississippi River");
        question.setAnswer4("Nile River");
        question.setConrrectAnswer(3);
        scenes[SceneType.Nauvoo.ordinal()].setQuestion(question);

//Scene 2 SUGAR CREEK
        scenes[SceneType.SugarCreek.ordinal()] = new Scene();

        scenes[SceneType.SugarCreek.ordinal()].setDescription("It is a little town in the State of Illinois, seven miles from Nauvoo");
        scenes[SceneType.SugarCreek.ordinal()].setName("SugarCreek");
        scenes[SceneType.SugarCreek.ordinal()].setSymbol("SC");
        question = new Question();
        question.setQuestion("What is the name of the little town in the State of Ilinois?");
        question.setAnswer1("Sugar Creek");
        question.setAnswer2("Centerville");
        question.setAnswer3("New York");
        question.setAnswer4("Seatle");
        question.setConrrectAnswer(1);
        scenes[SceneType.SugarCreek.ordinal()].setQuestion(question);
        

//Scene 3 RICHARDSON'S POINT
        scenes[SceneType.RichardsonsPoint.ordinal()] = new Scene();

        scenes[SceneType.RichardsonsPoint.ordinal()].setDescription("Richardson's Point was home to the pioneers for nearly two unexpected weeks (March 7-19, 1846)");
        scenes[SceneType.RichardsonsPoint.ordinal()].setName("Richardson’s Point");
        scenes[SceneType.RichardsonsPoint.ordinal()].setSymbol("RP");
        question = new Question();
        question.setQuestion("What is the name of the city that  was home to the pioneers for nearly two unexpected weeks (March 7-19, 1846)?");
        question.setAnswer1("Kids Point");
        question.setAnswer2("This is The Place");
        question.setAnswer3("Richardson's Point");
        question.setAnswer4("Curret Point");
        question.setConrrectAnswer(3);
        scenes[SceneType.RichardsonsPoint.ordinal()].setQuestion(question);
        

//Scene 4 CHARITON RIVER CROSSING
        scenes[SceneType.CharitonRiverCrossing.ordinal()] = new Scene();

        scenes[SceneType.CharitonRiverCrossing.ordinal()].setDescription("45 miles from Richardson’s Point , Chariton River is in southwest Iowa and Northeast Missouri");
        scenes[SceneType.CharitonRiverCrossing.ordinal()].setName("CharitonRiverCrossing");
        scenes[SceneType.CharitonRiverCrossing.ordinal()].setSymbol("CR");
        question = new Question();
        question.setQuestion("What is the name of the city that s in southwest Iowa and Northeast Missouri?");
        question.setAnswer1("Pond Crossingquer");
        question.setAnswer2("Chariton River Crossing");
        question.setAnswer3("Richardson's Point");
        question.setAnswer4("Missouri Crossing");
        question.setConrrectAnswer(2);
        scenes[SceneType.CharitonRiverCrossing.ordinal()].setQuestion(question);

//Scene 5 LOCUST CREEK
        scenes[SceneType.LocustCreek.ordinal()] = new Scene();

        scenes[SceneType.LocustCreek.ordinal()].setDescription("23 miles from Chariton River, Locust Creek is in Iowa State, milder weather on winter");
        scenes[SceneType.LocustCreek.ordinal()].setName("LocustCreek");
        scenes[SceneType.LocustCreek.ordinal()].setSymbol("LC");
        question = new Question();
        question.setQuestion("What is the name of the place that has a mild weather in Iowa?");
        question.setAnswer1("Palm Beach");
        question.setAnswer2("Minessota");
        question.setAnswer3("Chile");
        question.setAnswer4("Lotust Creek");
        question.setConrrectAnswer(4);
        scenes[SceneType.LocustCreek.ordinal()].setQuestion(question);

//Scene 6 GARDEN GROVE
        scenes[SceneType.GardenGrove.ordinal()] = new Scene();

        scenes[SceneType.GardenGrove.ordinal()].setDescription("25 miles from Locust Creek, Garden Grove is a small town in Iowa State");
        scenes[SceneType.GardenGrove.ordinal()].setName("GardenGrove");
        scenes[SceneType.GardenGrove.ordinal()].setSymbol("GG");
        question = new Question();
        question.setQuestion("What is the name of the place that has a mild weather in Iowa?");
        question.setAnswer1("Palm Beach");
        question.setAnswer2("Minessota");
        question.setAnswer3("Chile");
        question.setAnswer4("Lotust Creek");
        question.setConrrectAnswer(4);
        scenes[SceneType.GardenGrove.ordinal()].setQuestion(question);

//Scene 7 NISHNABOTNA RIVER
        scenes[SceneType.NishnabotnaRiver.ordinal()] = new Scene();

        scenes[SceneType.NishnabotnaRiver.ordinal()].setDescription("79 miles from Mount Pisgah, Nishnabotna River is a tributary of the Missouri River");
        scenes[SceneType.NishnabotnaRiver.ordinal()].setName("NishnabotnaRiver");
        scenes[SceneType.NishnabotnaRiver.ordinal()].setSymbol("NR");
        question = new Question();
        question.setQuestion("What is the name of the river that is a tributary of the Missouri River?");
        question.setAnswer1("NishnabotnaRiver");
        question.setAnswer2("River River");
        question.setAnswer3("Amazon River");
        question.setAnswer4("Rio Grande River");
        question.setConrrectAnswer(1);
        scenes[SceneType.NishnabotnaRiver.ordinal()].setQuestion(question);

//Scene 8 GRAND ENCAMPMENT
        scenes[SceneType.GrandEncampment.ordinal()] = new Scene();

        scenes[SceneType.GrandEncampment.ordinal()].setDescription("23 miles from Nishnabotna River, Grand Encampment is a stopping point as pioneers approach Missouri River");
        scenes[SceneType.GrandEncampment.ordinal()].setName("GrandEncampment");
        scenes[SceneType.GrandEncampment.ordinal()].setSymbol("GE");
        question = new Question();
        question.setQuestion("What is the name of a stopping point for the pioneers?");
        question.setAnswer1("Rio Grande Encampment");
        question.setAnswer2("Happy Camping");
        question.setAnswer3("GrandEncampment");
        question.setAnswer4("Wasatch Mountain");
        question.setConrrectAnswer(3);
        scenes[SceneType.GrandEncampment.ordinal()].setQuestion(question);

//Scene 9 COUNCIL BLUFFS
        scenes[SceneType.CouncilBluffs.ordinal()] = new Scene();

        scenes[SceneType.CouncilBluffs.ordinal()].setDescription("10 miles from Grand Encampment, Council Bluffs is a city in Iowa State");
        scenes[SceneType.CouncilBluffs.ordinal()].setName("CouncilBluffs");
        scenes[SceneType.CouncilBluffs.ordinal()].setSymbol("CB");
        question = new Question();
        question.setQuestion("What is the name of a city that is 10 miles from Grand Encampment, in Iowa State?");
        question.setAnswer1("Buenos Aires");
        question.setAnswer2("Cairo");
        question.setAnswer3("CouncilBluffs");
        question.setAnswer4("Jerusalem");
        question.setConrrectAnswer(3);  
        scenes[SceneType.CouncilBluffs.ordinal()].setQuestion(question);

//Scene 10 COUNCIL BLUFFS
        scenes[SceneType.WinterQuarters.ordinal()] = new Scene();

        scenes[SceneType.WinterQuarters.ordinal()].setDescription("1 mile from Council Bluffs. Winter Quarters is a city in Nebraska");
        scenes[SceneType.WinterQuarters.ordinal()].setName("Winter Quarters");
        scenes[SceneType.WinterQuarters.ordinal()].setSymbol("WQ");
        question = new Question();
        question.setQuestion("What is the name of a city that is 1 miles from Council Bluffs, in Nebraska State?");
        question.setAnswer1("London");
        question.setAnswer2("Winter Quarters");
        question.setAnswer3("Holand");
        question.setAnswer4("Mexico City");
        question.setConrrectAnswer(2); 
        scenes[SceneType.WinterQuarters.ordinal()].setQuestion(question);

//Scene 11 ELKRORN RIVER CROSSING
        scenes[SceneType.ElkhornRiverCrossing.ordinal()] = new Scene();

        scenes[SceneType.ElkhornRiverCrossing.ordinal()].setDescription("27 miles from Winter Quarters, Elkhorn River is in Nebraska");
        scenes[SceneType.ElkhornRiverCrossing.ordinal()].setName("Elkhorn River Crossing");
        scenes[SceneType.ElkhornRiverCrossing.ordinal()].setSymbol("ER");
        question = new Question();
        question.setQuestion("What is the name of the river that is 27 miles from Winter Quarters, in Nebraska State?");
        question.setAnswer1("Elkhorn River Crossing");
        question.setAnswer2("Danube");
        question.setAnswer3("Mekong");
        question.setAnswer4("Rio Grande River");
        question.setConrrectAnswer(1); 
        scenes[SceneType.ElkhornRiverCrossing.ordinal()].setQuestion(question);
        
//Scene 12 PLATTE RIVER
        scenes[SceneType.PlatteRiver.ordinal()] = new Scene();

        scenes[SceneType.PlatteRiver.ordinal()].setDescription("12 miles from Elkhorn Rive, Platte River is in Nebraska State");
        scenes[SceneType.PlatteRiver.ordinal()].setName("Platte River");
        scenes[SceneType.PlatteRiver.ordinal()].setSymbol("PR");
        question = new Question();
        question.setQuestion("What is the name of the river that is 12 miles from Elkhorn River, in Nebraska State?");
        question.setAnswer1("Black River");
        question.setAnswer2("Platte River");
        question.setAnswer3("Oder");
        question.setAnswer4("Sutlej");
        question.setConrrectAnswer(2); 
        scenes[SceneType.PlatteRiver.ordinal()].setQuestion(question);
        
//Scene 13 PLATTE RIVER
        scenes[SceneType.FortKearny.ordinal()] = new Scene();

        scenes[SceneType.FortKearny.ordinal()].setDescription("117 miles from Loup Fork, Fort Kearny is located in Nebraska State");
        scenes[SceneType.FortKearny.ordinal()].setName("Fort Kearny");
        scenes[SceneType.FortKearny.ordinal()].setSymbol("FK");
        question = new Question();
        question.setQuestion("What is the name of the river that is 117 miles from Loup Fork, in Nebraska State?");
        question.setAnswer1("Alibaba");
        question.setAnswer2("Fort Kearny");
        question.setAnswer3("Zion Zion");
        question.setAnswer4("Saint George");
        question.setConrrectAnswer(2); 
        
//Scene 14 CONFLUENCE POINT
        scenes[SceneType.ConfluencePoint.ordinal()] = new Scene();

        scenes[SceneType.ConfluencePoint.ordinal()].setDescription("93 miles from Fort Kearny, is a river in Nebraska State");
        scenes[SceneType.ConfluencePoint.ordinal()].setName("Confluence Point");
        scenes[SceneType.ConfluencePoint.ordinal()].setSymbol("CP");
        question = new Question();
        question.setQuestion("What is the name of the river that is 93 miles from Fort Kearny, in Nebraska State?");
        question.setAnswer1("Toronto");
        question.setAnswer2("Rome");
        question.setAnswer3("Egypt");
        question.setAnswer4("Confluence Point");
        question.setConrrectAnswer(4);
        scenes[SceneType.ConfluencePoint.ordinal()].setQuestion(question);
        
//Scene 15 ASH HOLLOW
        scenes[SceneType.AshHollow.ordinal()] = new Scene();

        scenes[SceneType.AshHollow.ordinal()].setDescription("83 miles from Confluence Point, is a camp in Nebraska State");
        scenes[SceneType.AshHollow.ordinal()].setName("Ash Hollow");
        scenes[SceneType.AshHollow.ordinal()].setSymbol("AH");
        question = new Question();
        question.setQuestion("What is the name of the camp that is 83 miles from Confluence Point, in Nebraska State?");
        question.setAnswer1("Camp Davis");
        question.setAnswer2("Ash Hollow");
        question.setAnswer3("Brave Camp");
        question.setAnswer4("Tent Camp");
         question.setConrrectAnswer(2);
         scenes[SceneType.AshHollow.ordinal()].setQuestion(question);
         
//Scene 16 CHIMNEY ROCKS
        scenes[SceneType.ChimneyRock.ordinal()] = new Scene();

        scenes[SceneType.ChimneyRock.ordinal()].setDescription("72 miles from Ash Hollow, is a geological rock in Nebraska State");
        scenes[SceneType.ChimneyRock.ordinal()].setName("Chimney Rocks");
        scenes[SceneType.ChimneyRock.ordinal()].setSymbol("CH");
        question = new Question();
        question.setQuestion("What is the name of the place that is a geological rock in Nebraska State?");
        question.setAnswer1("Chimney Rocks");
        question.setAnswer2("Lava Cake");
        question.setAnswer3("Moab");
        question.setAnswer4("Rocky Mountain");
        question.setConrrectAnswer(1);
        scenes[SceneType.ChimneyRock.ordinal()].setQuestion(question);
        
//Scene 17 SCOTTS BLUFF
        scenes[SceneType.ScottsBluff.ordinal()] = new Scene();

        scenes[SceneType.ScottsBluff.ordinal()].setDescription("72 miles from Ash Hollow, is a geological rock in Nebraska State");
        scenes[SceneType.ScottsBluff.ordinal()].setName("Scotts Bluff");
        scenes[SceneType.ScottsBluff.ordinal()].setSymbol("SB");
        question = new Question();
        question.setQuestion("What is the name of the place that is 72 miles from Ash Hollow, in Nebraska State?");
        question.setAnswer1("Scotts Bluff");
        question.setAnswer2("Hillary Duff");
        question.setAnswer3("Volga");
        question.setAnswer4("Oder");
        question.setConrrectAnswer(1);
        scenes[SceneType.ScottsBluff.ordinal()].setQuestion(question);
        
//Scene 18 FORT LARAMIE
        scenes[SceneType.FortLaramie.ordinal()] = new Scene();

        scenes[SceneType.FortLaramie.ordinal()].setDescription("50 miles from Scotts Bluff, is in Wyoming State");
        scenes[SceneType.FortLaramie.ordinal()].setName("Fort Laramie");
        scenes[SceneType.FortLaramie.ordinal()].setSymbol("FL");
        question = new Question();
        question.setQuestion("What is the name of the place that is 50 miles from Scotts Bluff, is in Wyoming State?");
        question.setAnswer1("Fort Apache");
        question.setAnswer2("West Jordan");
        question.setAnswer3("Fort Laramie");
        question.setAnswer4("Nephi");
        question.setConrrectAnswer(3);
        scenes[SceneType.FortLaramie.ordinal()].setQuestion(question);
        
//Scene 19 SWEETWATER RIVER
        scenes[SceneType.SweetwaterRiver.ordinal()] = new Scene();

        scenes[SceneType.SweetwaterRiver.ordinal()].setDescription("495 miles from Fort Laramie, is a river in Wyoming, is part of the Mississippi River.");
        scenes[SceneType.SweetwaterRiver.ordinal()].setName("Sweetwater River");
        scenes[SceneType.SweetwaterRiver.ordinal()].setSymbol("SR");
        question = new Question();
        question.setQuestion("What is the name of a river in Wyoming that is also part of the Mississippi River?");
        question.setAnswer1("Sweetwater River");
        question.setAnswer2("Brahmaputra");
        question.setAnswer3("Guadiana");
        question.setAnswer4("Patomic Riveri");
        question.setConrrectAnswer(1);
        scenes[SceneType.SweetwaterRiver.ordinal()].setQuestion(question);
        
//Scene 20 INDEPENDENCE ROCK
        scenes[SceneType.IndependenceRock.ordinal()] = new Scene();

        scenes[SceneType.IndependenceRock.ordinal()].setDescription("672 miles from Sweet water River, is a large granite rock in Wyoming State");
        scenes[SceneType.IndependenceRock.ordinal()].setName("Independence Rock");
        scenes[SceneType.IndependenceRock.ordinal()].setSymbol("IR");
        question = new Question();
        question.setQuestion("What is the name of the place the pioneers passed by and it is a large granite rock in Wyoming State?");
        question.setAnswer1("Independence Rock");
        question.setAnswer2("Hard Rock");
        question.setAnswer3("Moab");
        question.setAnswer4("Rocky Mountain");
        question.setConrrectAnswer(1);
        scenes[SceneType.IndependenceRock.ordinal()].setQuestion(question);
        
//Scene 21 FORT BRIDGER
        scenes[SceneType.FortBridger.ordinal()] = new Scene();

        scenes[SceneType.FortBridger.ordinal()].setDescription("218 miles from Independence Rock, is in Wyoming State");
        scenes[SceneType.FortBridger.ordinal()].setName("Fort Bridger");
        scenes[SceneType.FortBridger.ordinal()].setSymbol("FB");
        question = new Question();
        question.setQuestion("What is the name of the place that is 218 miles from Independence Rock in Wyoming State?");
        question.setAnswer1("Puerto Rico");
        question.setAnswer2("New Zeland");
        question.setAnswer3("Fort Bridger");
        question.setAnswer4("Bora Bora");
        question.setConrrectAnswer(3);
        scenes[SceneType.FortBridger.ordinal()].setQuestion(question);
        
//Scene 22 FORT BRIDGER
        scenes[SceneType.EchoCanyon.ordinal()] = new Scene();

        scenes[SceneType.EchoCanyon.ordinal()].setDescription("59 miles from Fort Bridger, is the last canyon in Wyoming State");
        scenes[SceneType.EchoCanyon.ordinal()].setName("Echo Canyon");
        scenes[SceneType.EchoCanyon.ordinal()].setSymbol("EC");
        question = new Question();
        question.setQuestion("What is the name of the place that is is the last canyon the pioneers passed in Wyoming State?");
        question.setAnswer1("Antelope Canyon");
        question.setAnswer2("Catarat Canyon");
        question.setAnswer3("High Canyon");
        question.setAnswer4("Echo Canyon");
        question.setConrrectAnswer(4);
        scenes[SceneType.EchoCanyon.ordinal()].setQuestion(question);
        
//Scene 23 GOLDEN PASS ROAD
        scenes[SceneType.GoldenPassRoad.ordinal()] = new Scene();

        scenes[SceneType.GoldenPassRoad.ordinal()].setDescription("35 miles from Echo Canyon, it is a Utah road");
        scenes[SceneType.GoldenPassRoad.ordinal()].setName("Golden Pass Road");
        scenes[SceneType.GoldenPassRoad.ordinal()].setSymbol("GP");
        question = new Question();
        question.setQuestion("What is the name of the place that is 35 miles from Echo Canyon, it is a Utah road?");
        question.setAnswer1("Interstate - 80");
        question.setAnswer2("Golden Pass Road");
        question.setAnswer3("Legacy");
        question.setAnswer4("Interstate -15");
        question.setConrrectAnswer(2);
        scenes[SceneType.GoldenPassRoad.ordinal()].setQuestion(question);
        
//Scene 24 GOLDEN PASS ROAD
        scenes[SceneType.EmigrationCanyon.ordinal()] = new Scene();

        scenes[SceneType.EmigrationCanyon.ordinal()].setDescription("2 miles from Golden Pass Road, is a valley in Utah State");
        scenes[SceneType.EmigrationCanyon.ordinal()].setName("Emigration Canyon");
        scenes[SceneType.EmigrationCanyon.ordinal()].setSymbol("EC");
        question = new Question();
        question.setQuestion("What is the name of the first valley the pioneers stopped in Utah State?");
        question.setAnswer1("Emigration Canyon");
        question.setAnswer2("Death Valley");
        question.setAnswer3("Rocky Mountain");
        question.setAnswer4("Wasatch");
        question.setConrrectAnswer(1);
        scenes[SceneType.EmigrationCanyon.ordinal()].setQuestion(question);
        
//Scene 25 ZION
        scenes[SceneType.Zion.ordinal()] = new Scene();

        scenes[SceneType.Zion.ordinal()].setDescription("14 miles from Emigration Canyon, Final destination");
        scenes[SceneType.Zion.ordinal()].setName("Zion");
        scenes[SceneType.Zion.ordinal()].setSymbol("ZN");
        question = new Question();
        question.setQuestion("What is the name of the pioneers final destination?");
        question.setAnswer1("Russia");
        question.setAnswer2("Chile");
        question.setAnswer3("Zion");
        question.setAnswer4("Milan");
        question.setConrrectAnswer(1);
        scenes[SceneType.Zion.ordinal()].setQuestion(question);
        return scenes;
    }

    public static Question[] createQuestions() throws MapControlException{
        System.out.println("Create Questions called");
        throw new MapControlException();
    }

    public static void assignQuestionsToScenes(Question[] questions,
            Scene[] scenes) {
        System.out.println("Assign Questions to Scenes called");
    }

    public static void assignItemsToScenes(Scene[] scenes) {
        ArrayList<Resource> items = PioneerTrail.getCurrentGame().getResources();
        System.out.println("Assign Items to Scenes called");
        
    }

    public static void assignScenesToLocations(Scene[] scenes, Location[][] locations) {
        System.out.println("Assign Scenes to Locations called");
      
      locations[0][0].setScene(scenes[SceneType.Nauvoo.ordinal()]);
      locations[0][1].setScene(scenes[SceneType.SugarCreek.ordinal()]);
      locations[0][2].setScene(scenes[SceneType.RichardsonsPoint.ordinal()]);
      locations[0][3].setScene(scenes[SceneType.CharitonRiverCrossing.ordinal()]);
      locations[0][4].setScene(scenes[SceneType.LocustCreek.ordinal()]);
     
      locations[1][0].setScene(scenes[SceneType.GardenGrove.ordinal()]);
      locations[1][1].setScene(scenes[SceneType.NishnabotnaRiver.ordinal()]);
      locations[1][2].setScene(scenes[SceneType.GrandEncampment.ordinal()]);
      locations[1][3].setScene(scenes[SceneType.CouncilBluffs.ordinal()]);
      locations[1][4].setScene(scenes[SceneType.WinterQuarters.ordinal()]);
      
      locations[2][0].setScene(scenes[SceneType.ElkhornRiverCrossing.ordinal()]);
      locations[2][1].setScene(scenes[SceneType.PlatteRiver.ordinal()]);
      locations[2][2].setScene(scenes[SceneType.FortKearny.ordinal()]);
      locations[2][3].setScene(scenes[SceneType.ConfluencePoint.ordinal()]);
      locations[2][4].setScene(scenes[SceneType.AshHollow.ordinal()]);
      
      locations[3][0].setScene(scenes[SceneType.ChimneyRock.ordinal()]);
      locations[3][1].setScene(scenes[SceneType.ScottsBluff.ordinal()]);
      locations[3][2].setScene(scenes[SceneType.FortLaramie.ordinal()]);
      locations[3][3].setScene(scenes[SceneType.SweetwaterRiver.ordinal()]);
      locations[3][4].setScene(scenes[SceneType.IndependenceRock.ordinal()]);
      
      locations[4][0].setScene(scenes[SceneType.FortBridger.ordinal()]);
      locations[4][1].setScene(scenes[SceneType.EchoCanyon.ordinal()]);
      locations[4][2].setScene(scenes[SceneType.GoldenPassRoad.ordinal()]);
      locations[4][3].setScene(scenes[SceneType.EmigrationCanyon.ordinal()]);
      locations[4][4].setScene(scenes[SceneType.Zion.ordinal()]);
    }
}
