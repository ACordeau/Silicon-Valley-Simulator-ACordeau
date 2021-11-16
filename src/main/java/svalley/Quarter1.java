package main.java.svalley;

public class Quarter1 implements Quarters {

    private Gameplay game;
    private TechGiant tg1 = null;
    private TechGiant tg2 = null;
    
    public Quarter1(Gameplay newGame) {

        game = newGame;

    }

    @Override
    public void setQuarter1() {
        System.out.println("\nStarting Quarter 1");
        System.out.println("STARTUPS OF TYPE IMAGE SHARING LOSE 50% REVENUE!");
        game.setQuarterState(game.getQuarter1());
        
        setTechGiants();
        int lostHp;
        int startHp;
        String type;
        
        for (int i = 0; i < tg1.getStartups().size(); i++) {
            
            startHp = tg1.getStartups().get(i).getHealth();
            type = tg1.getStartups().get(i).getType();
            
            if (type.equals("IMAGE_SHARING")) {
                lostHp = (int)(startHp * .5);
                tg1.getStartups().get(i).setCurrentHealth(lostHp);
            }
        }

    }

    @Override
    public void setQuarter2() {
        System.out.println("Error Message");

    }

    @Override
    public void setQuarter3() {
        System.out.println("Error Message");

    }

    @Override
    public void setQuarter4() {
        System.out.println("Error Message");

    }

    @Override
    public void undo() {
        
        System.out.println("\nEnding Quarter 1");
        System.out.println("All revenue lost during this quarter is returned"
                + " by investors!");
        
        setTechGiants();
        int gainHp;
        int startHp;
        int currentHp;
        String type;
        
        for (int i = 0; i < tg1.getStartups().size(); i++) {
            startHp = tg1.getStartups().get(i).getHealth();
            currentHp = tg1.getStartups().get(i).getCurrentHealth();
            type = tg1.getStartups().get(i).getType();
            
            if (type.equals("IMAGE_SHARING")) {
                gainHp = (int)(startHp * .5);
                tg1.getStartups().get(i).setCurrentHealth(currentHp + gainHp);
            }
        }
        
    }
    
    private void setTechGiants() {
        tg1 = game.getTechGiant1();
        tg2 = game.getTechGiant2();
    }

}
