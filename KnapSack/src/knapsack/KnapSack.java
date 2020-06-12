
package knapsack;

/**
 *
 * @author Dani
 */
public class KnapSack {

    private int tárgyakszáma;
    private int maxkapacitás; // Amennyi tárgy belefér a hátizsákba maximum
    private int[] sulyTárgyak; // ez a súlya egy adott tárgynak (Kg)
    private int[] értékeTárgynak; // az értéke egy adott tárgynak (Ft)
    private int összérték; // A hátizsákban lévő tárgyak összértéke (Ft)
    private int[][] tárgyakrakása; //Az adott tárgyak elhelyezése a hátizsákban. Ezt 0-ával és 1-essel jelüljük majd, hogy ha van a zsákba akkor 1-es, ha nincs akkor 0.
    
    public KnapSack(int tárgyakszáma, int maxkapacitás, int[] sulyTárgyak, int[] értékeTárgynak){
        this.tárgyakszáma = tárgyakszáma;
        this.maxkapacitás = maxkapacitás;
        this.sulyTárgyak = sulyTárgyak;
        this.értékeTárgynak = értékeTárgynak;
    }
    
    
    public void megodlottProbléma()
    {
        int[][] hátizsák = new int[tárgyakszáma+1][maxkapacitás+1]; // Feltöltöm a hátizsákot tárgyakkal és azoknak az értékeivel
        this.tárgyakrakása = new int[tárgyakszáma+1][maxkapacitás+1];
        
        for (int i = 1; i <= this.tárgyakszáma; i++) {
            
            for (int j = 1; j <= this.maxkapacitás; j++) {
                
                int kivesz = hátizsák[i -1][j];
                
                int berak = 0; // Kezdeti érték
                if(sulyTárgyak[i] <= j){
                    berak = értékeTárgynak[i] + hátizsák[i-1][j-sulyTárgyak[i]]; // Ez az ellenörzés azért szükséges, mert ha a tárgyak tömege nem kisebb vagy egyenlő
                    //mint a j akkor 0-nak hagyjuk az értéket, viszont ha ezt az ellenörzést kihagynánk, akkor minusz értéket is kaphatnánk, és az hibát eredményezne
                    // A hátizsákban!
                }
                
                hátizsák[i][j] = Math.max(kivesz, berak);
                
                if(berak > kivesz){
                    tárgyakrakása[i][j] = 1; //Be teszünk egy tárgyat, i-indexxel.
                }
                else
                {
                    tárgyakrakása[i][j] = 0; // Nem teszünk be tárgyat i-indexxel.
                }   
            } 
        }
        this.összérték = hátizsák[tárgyakszáma][maxkapacitás]; // Itt megadjuk az összértékét a hátizsáknak és a kapacitását is egyben!
    }
    
    public void EredményMutatás()
    {
        System.out.println("Összérték: " + this.összérték + "Ft"); // Kiírjuk, hogy mennyi az értéke a tárgyaknak, amik a hátizsákban vannak
        
        for(int i = this.tárgyakszáma, j = this.maxkapacitás; i > 0; i--) // Megnézzük, hogy az i-index egyenlő e a tárgyak számával, illetve hogy a j index megegyezik e
            // a kapacitással, továbbá még azt ellenőrizzuk, hogy a tárgy nagyobb e mint nulla.
        {
            if(this.tárgyakrakása[i][j] == 1){
                System.out.println("Tárgyak : " +i +""); // Mivel kétdimenziós tömböt használunk a hátizsák feltöltéséhez, ezért kell vizsgálni, hogy hány 
                // tárgy van a zsákba, illetve hogy azoknak mekkora a méretük!
                j = j - this.sulyTárgyak[i];
            }
        }
        
        
    }
    
    
    
    
}
