
package knapsack;

/**
 *
 * @author Dani
 */
public class Application {
    
    public static void main(String[] args)
    {
        int tárgyakszáma = 3;
        int kapacitáshátizsák = 5;
        
        int[] sulyTárgynak = new int[tárgyakszáma+1]; // Hány kilós az adott tárgy a zsákban
        sulyTárgynak[1] = 4;
        sulyTárgynak[2] = 2;
        sulyTárgynak[3] = 3;
        //sulyTárgynak[4] = 5;
        //sulyTárgynak[5] = 8;
        //sulyTárgynak[6] = 9;
        
        int[] értékeTárgynak = new int[tárgyakszáma+1]; // Mennyibe kerül a tárgy amit a hátizsákba raktunk
        értékeTárgynak[1] = 10;
        értékeTárgynak[2] = 4;
        értékeTárgynak[3] = 7;
        //értékeTárgynak[4] = 3;
        //értékeTárgynak[5] = 5;
        //értékeTárgynak[6] = 8;
        
        KnapSack knapsack = new KnapSack( tárgyakszáma, kapacitáshátizsák, sulyTárgynak, értékeTárgynak);
        knapsack.megodlottProbléma();
        knapsack.EredményMutatás();
        
        
    }
}
