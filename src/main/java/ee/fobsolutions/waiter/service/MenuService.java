package ee.fobsolutions.waiter.service;

import ee.fobsolutions.waiter.dao.MenuItemRepository;
import ee.fobsolutions.waiter.dao.MenuRepository;
import ee.fobsolutions.waiter.models.menu.Menu;
import ee.fobsolutions.waiter.models.menu.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FOB Solutions
 */
@Service
public class MenuService {

    public enum MenuType {
        SALADS,
        SOUPS,
        MAINS,
        DRINKS,
        DESSERTS
    }

    @Autowired
    private MenuRepository repository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public Menu getMenuByName(MenuType type) {
        return repository.findByName(getMenuNameByType(type));
    }

    private Menu addMenu(String name, List<MenuItem> items) {
        if (name.isEmpty() || items.isEmpty()) {
            return null;
        } else {
            Menu menu = new Menu(name);
            menu.addItems(items);
            return repository.save(menu);
        }
    }

    public List<Menu> getFullMenu() {
        List<Menu> menus = new ArrayList<>();
        menus.add(getMenuByName(MenuType.SALADS));
        menus.add(getMenuByName(MenuType.MAINS));
        menus.add(getMenuByName(MenuType.SOUPS));
        menus.add(getMenuByName(MenuType.DESSERTS));
        menus.add(getMenuByName(MenuType.DRINKS));
        return menus;
    }

    public void addDefaultMenu() {

        List<MenuItem> startersMenu = new ArrayList<>();
        List<MenuItem> mainCoursesMenu = new ArrayList<>();
        List<MenuItem> soupsMenu = new ArrayList<>();
        List<MenuItem> dessertsMenu = new ArrayList<>();
        List<MenuItem> drinksMenu = new ArrayList<>();

        startersMenu.add(menuItemRepository.save(new MenuItem("STICK ICE CREAM MADE OF SPICED BALTIC SPRATS, SOFT EGG, FRESH CUCUMBER AND HERB SALAD WITH CREAMY DILL MILK", 8.00)));
        startersMenu.add(menuItemRepository.save(new MenuItem("AIRY COD LIVER MOUSSE WITH TROUT ROE, QUAIL EGG, AND CRISPY BREAD SLIVERS", 8.00)));
        startersMenu.add(menuItemRepository.save(new MenuItem("HOT AND AROMATIC OXTAIL BRAWN WITH WHIPPED SOUR CREAM AND HORSERADISH", 7.00)));
        startersMenu.add(menuItemRepository.save(new MenuItem("JÄRVEOTSA QUAIL PATE WITH CHERRY JELLY, ROASTED NUTS, QUINCE SAUCE, AND ROSEMARY THYME BREAD", 11.00)));
        startersMenu.add(menuItemRepository.save(new MenuItem("LOCAL FRESH CHOPPED BEEF WITH SALTED CHERRY TOMATOES, QUAIL EGG YOLK, SPICED SPRAT SAUCE, AND CUMIN CRACKERS", 14.00)));
        startersMenu.add(menuItemRepository.save(new MenuItem("KALAMATSI DAIRY GOAT’S CURD BAKE WITH COLOURFUL CARROT SALAD AND RASPBERRY ROSEMARY SAUCE", 10.00)));
        startersMenu.add(menuItemRepository.save(new MenuItem("FISHERMAN’S SALAD WITH PIKE CUTLETS AND SOUR CREAM-CAVIAR SAUCE", 11.00)));
        startersMenu.add(menuItemRepository.save(new MenuItem("LOCAL TOASTED BUCKWHEAT WITH HONEY-GLAZED BEET, GREEN VEGETABLES, HEMP SEED AND BLACK GARLIC MAYONNAISE, AND SEED CRACKERS (V)", 9.00)));
        startersMenu.add(menuItemRepository.save(new MenuItem("COLOURFUL SALAD OF VARIED TOMATOES, RED ONION AND AROMATIC HERBS (V) ", 9.00)));

        mainCoursesMenu.add(menuItemRepository.save(new MenuItem("GRILLED SAAREMAA DEER FILLET WITH POTATOES ROASTED WITH BLACK GARLIC, REINDEER LICHEN, CELERIAC CREAM AND RED WINE- BLACKBERRY SAUCE", 25.00)));
        mainCoursesMenu.add(menuItemRepository.save(new MenuItem("ESTONIAN ORGANIC BEEF HEART COOKED ON A GRILL WITH POTATO AND ROASTED GARLIC CREAM, JUNIPER-FLAVOURED VEGETABLES, AND TARRAGON BUTTER SAUCE", 16.00)));
        mainCoursesMenu.add(menuItemRepository.save(new MenuItem("JUICY DUCK FILLET WITH JERUSALEM ARTICHOKE CREAM, SMOKY LENTIL STEW, SPICE-MARINATED PEAR, RED WINE AND CHERRY SAUCE", 18.00)));
        mainCoursesMenu.add(menuItemRepository.save(new MenuItem("GRILLED TENDER LAMB WITH POTATO AND CELERIAC CREAM, TARRAGON CARROTS, CHARRED CAULIFLOWER, AND CREAMY ROASTED GARLIC SAUCE", 20.00)));
        mainCoursesMenu.add(menuItemRepository.save(new MenuItem("GAME CUTLETS WITH CREAMY POTATO MASH, BOLETUS AND CHANTERELLE RAGOUT, RED WINE AND ROSEMARY SAUCE", 18.00)));
        mainCoursesMenu.add(menuItemRepository.save(new MenuItem("BAKED COD FILLET WITH POTATO AND PARSLEY CREAM, HOT CARROT AND CELERY SALAD, BOLETUS MOUSSE, EGG YOLK AND BUTTER SAUCE", 20.00)));
        mainCoursesMenu.add(menuItemRepository.save(new MenuItem("FRIED PIKE PERCH WITH CAULIFLOWER CREAM, BUTTER-BRAISED GREEN VEGETABLES, AND HOLLANDAISE SAUCE", 18.00)));
        mainCoursesMenu.add(menuItemRepository.save(new MenuItem("RAW BUCKWHEAT-BOLETUS MUSHROOM CUTLETS WITH GRILLED ROMAINE SALAD, SHALLOT CREAM, RED WINE AND VEGETABLE SAUCE (V)", 14.00)));

        soupsMenu.add(menuItemRepository.save(new MenuItem("CHEF MIHKEL KALBUS RECOMMENDS: CREAMY SAUERKRAUT SOUP", 8.00)));
        soupsMenu.add(menuItemRepository.save(new MenuItem("RICH GAME BROTH WITH NUANCES OF LOG FIRE AND FOREST, GARDEN AND FIELD CROP", 8.00)));
        soupsMenu.add(menuItemRepository.save(new MenuItem("CREAMY ROASTED CELERIAC SOUP WITH WILD MUSHROOMS AND FARM’S CRISPY BREAD", 7.00)));
        soupsMenu.add(menuItemRepository.save(new MenuItem("LENTIL AND TOMATO SOUP WITH LOCAL VEGETABLES AND AROMATIC HERBS (V)", 6.00)));

        dessertsMenu.add(menuItemRepository.save(new MenuItem("VELVETY RYE MALT CREAM WITH BLACKCURRANT JELLY AND SPELT BISCUITS", 7.00)));
        dessertsMenu.add(menuItemRepository.save(new MenuItem("AIRY GOAT’S CHEESE-SOUR MILK MOUSSE WITH NUT AND FRUIT SALAD, AND BLACKBERRY SAUCE", 7.00)));
        dessertsMenu.add(menuItemRepository.save(new MenuItem("ESKO FARM’S YOGHURT AND LINDEN FLOWER JELLY WITH HOME-MADE MULTIGRAIN COOKIES AND RASPBERRY SAUCE", 7.00)));

        drinksMenu.add(menuItemRepository.save(new MenuItem("MOE MAHE VODKA 1886 4CL", 4.00)));
        drinksMenu.add(menuItemRepository.save(new MenuItem("HOPSTER PEARU IPA (IPA 6.5%)", 6.50)));
        drinksMenu.add(menuItemRepository.save(new MenuItem("FARM APPLE CIDER 37,5CL", 6.50)));
        drinksMenu.add(menuItemRepository.save(new MenuItem("VÄRSKA STILL/SPARKLING WATER 33CL", 3.00)));
        drinksMenu.add(menuItemRepository.save(new MenuItem("HENNESSY XO", 28.00)));
        drinksMenu.add(menuItemRepository.save(new MenuItem("CAFFEE CREMA", 2.50)));
        drinksMenu.add(menuItemRepository.save(new MenuItem("Taittinger Brut Reserve 75cl", 110.00)));
        drinksMenu.add(menuItemRepository.save(new MenuItem("Moet & Chandon Brut Imperial 75cl", 128.00)));
        drinksMenu.add(menuItemRepository.save(new MenuItem("Gaja Dagromis Barolo DOCG, Piemonte 2009 75cl", 130.00)));

        addMenu(getMenuNameByType(MenuType.SALADS), startersMenu);
        addMenu(getMenuNameByType(MenuType.MAINS), mainCoursesMenu);
        addMenu(getMenuNameByType(MenuType.SOUPS), soupsMenu);
        addMenu(getMenuNameByType(MenuType.DESSERTS), dessertsMenu);
        addMenu(getMenuNameByType(MenuType.DRINKS), drinksMenu);

    }

    public void reset() {
        repository.deleteAll();
    }

    private String getMenuNameByType(MenuType type) {

        switch (type) {
            case MAINS:
                return "MAIN COURSES";
            case SOUPS:
                return "SOUPS";
            case DRINKS:
                return "DRINKS";
            case SALADS:
                return "STARTERS AND SALADS";
            case DESSERTS:
                return "DESSERTS";
            default:
                return null;
        }
    }

}
