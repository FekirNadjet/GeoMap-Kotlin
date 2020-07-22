package com.example.projet

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.projet.Adapters.PaysAdapters
import com.example.projet.data.*
import com.example.projet.data.PaysDB.Companion
import kotlinx.android.synthetic.main.fragment_liste_pays.*
import kotlinx.coroutines.launch

class listePays : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liste_pays, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Liste des pays"

        val event1 = Historique("19th century colonialism", "North African boundaries have shifted during various stages of the conquests. The borders of modern Algeria were created by the French, whose colonization began in 1830 (French invasion began on July 5). To benefit French colonists (many of whom were not in fact of French origin but Italian, Maltese, and Spanish) and nearly the entirety of whom lived in urban areas, northern Algeria was eventually organized into overseas departments of France, with representatives in the French National Assembly. France controlled the entire country, but the traditional Muslim population in the rural areas remained separated from the modern economic infrastructure of the European community.")
        val event2 = Historique( "Rise of Algerian nationalism and French resistance", "A new generation of Islamic leadership emerged in Algeria at the time of World War I and grew to maturity during the 1920s and 1930s. Various groups were formed in opposition to French rule, most notable the National Liberation Front (FLN) and the National Algerian Movement.")
        val event3 = Historique("Ben Bella presidency (1962–65)", "The referendum was held in Algeria on 1 July 1962, and France declared Algeria independent on 3 July. On 8 September 1963, a constitution was adopted by referendum, and later that month, Ahmed Ben Bella was formally elected the first president, after receiving support from the military, led by Houari Boumediène. The war for independence and its aftermath had severely disrupted Algeria's society and economy. In addition to the physical destruction, the exodus of the colons deprived the country of most of its managers, civil servants, engineers, teachers, physicians, and skilled workers. The homeless and displaced numbered in the hundreds of thousands, many suffering from illness, and some 70 percent of the workforce was unemployed.")

        val histoires1= listOf<Historique>(event1,event2,event3)

        val res1 = Ressources("Oil", "Algeria is one of the biggest oil producers in the world.")
        val res2 = Ressources("Natural gas", "Algeria has abundant natural gas reserves.")
        val res3 = Ressources( "Helium", "Algeria has approximately 21% of the world’s helium deposits, and is the second largest producer of helium, after the United States.")
        val res4 = Ressources( "Gold", "Algeria has many gold deposits within its borders.")

        val ressources1= listOf<Ressources>(res1,res2,res3,res4)
        val tweets= listOf<Tweet>()
        val slideAlgerie= listOf<Int>(R.drawable.algerie1,R.drawable.algerie2,R.drawable.algerie3,R.drawable.algerie4)
        val descr="is a country in the Maghreb region of North Africa. The capital and most populous city is Algiers, located in the far north of the country on the Mediterranean coast. With an area of 2,381,741 square kilometres (919,595 sq mi), Algeria is the tenth-largest country in the world, and the largest by area in the African Union and the Arab world.[10] With an estimated population of over 44 million, it is the eighth-most populous country in Africa."
        val dz = Pays("DZ","Algeria","Algiers", descr, 2381741, 42972878,histoires1,ressources1, R.drawable.algerie_drapeau, slideAlgerie,R.raw.algerie,tweets)

        val event6 = Historique( "Postwar growth and prosperity", "Shigeru Yoshida served as prime minister in 1946–1947 and 1948–1954, and played a key role in guiding Japan through the occupation.[292] His policies, known as the Yoshida Doctrine, proposed that Japan should forge a tight relationship with the United States and focus on developing the economy rather than pursuing a proactive foreign policy.[293] Yoshida was one of the longest serving prime ministers in Japanese history and the third-longest serving Prime Minister in Post-occupation Japan.[294] Yoshida's Liberal Party merged in 1955 into the new Liberal Democratic Party (LDP),[295] which went on to dominate Japanese politics for the remainder of the Shōwa period")
        val event4 = Historique( "Heisei period (1989–2019)", "Emperor Akihito's reign began upon the death of his father, Emperor Hirohito. The economic bubble popped in 1989, and stock and land prices plunged as Japan entered a deflationary spiral. Banks found themselves saddled with insurmountable debts that hindered economic recovery.[317] Stagnation worsened as the birthrate declined far below replacement level")
        val event5 = Historique( "Reiwa period (2019–present)", "Emperor Naruhito's reign began upon the abdication of his father, Emperor Akihito, on May 1, 2019.")

        val histoires2= listOf<Historique>(event4,event5,event6)

        val res5 = Ressources( "Minerals", "With few exceptions, Japan’s mineral reserves are small, and the quality of those mined is often poor.")
        val res6 = Ressources( "Mining and quarrying", "Mining for iron and copper essentially ceased after 2000, and Japan now imports virtually all its needs for those two ores.")
        val res7 = Ressources( "Power", "The largest single source of energy is oil;")

        val ressources2= listOf<Ressources>(res1,res2,res3,res4)
        val slideJapon= listOf<Int>(R.drawable.japon1,R.drawable.japon2,R.drawable.japon3)


        val jp = Pays("JP", "Japan", "Tokyo", "", 377975, 126150000,histoires2,ressources2, R.drawable.japon_drapeau,slideJapon,R.raw.suede,tweets)


        var pays= listOf<Pays>(dz,jp)



        launch {
            context?.let {
                //pays=PaysDB(it).paysDao().getAll()
                list.adapter= PaysAdapters(pays)
            }
        }

//        button_add.setOnClickListener{
//
//            //PaysDB(it).paysDao().addPays(dz)
//                    val action=listePaysDirections.actionDetailPays()
//                    Navigation.findNavController(it).navigate(action)
//
//        }


    }


}
