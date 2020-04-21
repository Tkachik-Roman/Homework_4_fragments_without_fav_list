package com.example.homework_4_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class MovieListFragment : Fragment() {

    var listener: OnMoviesClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {

            return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = MoviesAdapter(
            LayoutInflater.from(context),
            listOf(
                RecyclerMoviesItem(R.drawable.ford_vs_ferrari, "Форд против Феррари", "Сюжет повествует о " +
                        "группе американских инженеров. В 1960-х под руководством конструктора " +
                        "Кэрролла Шелби и при поддержке британского гонщика Кена Майлса они должны были  " +
                        "с нуля сделать абсолютно новый спорткар, способный опередить Феррари - " +
                        "непобедимого чемпиона 24-часовой гонки на выносливость Ле-Ман", 0),
                RecyclerMoviesItem(R.drawable.holiday, "Каникулы", "Расти примерный семьянин, " +
                        "который очень хочет сплотить семью и воссоздать каникулы из своего детства. " +
                        "Вместе с супругой и двумя сыновьями он решает совершить незабываемое путешествие" +
                        " через всю страну, конечной целью которого станет самый лучший тематический " +
                        "парк Америки. Все тщательно спланировав, они отправляются в дорогу, надеясь, " +
                        "что их ждет очень веселое и увлекательное путешествие", 1),
                RecyclerMoviesItem(R.drawable.pain_and_gain, "Кровью и потом", "Однажды тренеру по фитнесу " +
                        "надоело ходить в трениках. Он решил круто изменить свою судьбу и разбогатеть. " +
                        "Нашел двух других незадачливых качков и предложил им план похищения своего " +
                        "клиента-миллионера. Но если в организме мышц больше, чем мозгов, то даже " +
                        "самый лучший план, подсмотренный в экшен-боевике, может не сработать…", 2),
                RecyclerMoviesItem(R.drawable.bronx_tale, "Бронкская история","Гангстер Санни - большой " +
                        "человек в квартале Бронкса.Убийство, совершенное Санни, положило начало " +
                        "странной дружбе между мафиози и 9 летним подростком Калоджеро. Калоджеро  " +
                        "предстоит выбрать: будет ли он зарабатывать уважение тяжким трудом, как отец, " +
                        "или пойдет по преступному пути, как Санни...", 3),
                RecyclerMoviesItem(R.drawable.carlitos_way, "Путь Карлито", "Один из главарей наркомафии, " +
                        "пуэрториканец Карлито Бриганте, с помощью своего адвоката досрочно выходит на " +
                        "свободу. Карлито - уже немолодой, но всё ещё привлекательный и статный мужчина " +
                        "решает порвать со своим преступным прошлым и начать новую, более праведную " +
                        "жизнь, но возможно ли это...", 4),
                RecyclerMoviesItem(R.drawable.cidad_de_deus, "Город бога", "Город Бога - самый бедный и " +
                        "самый криминальный квартал Рио-де-Жанейро, где нет законов, нет властей, а " +
                        "правила существования устанавливают банды наркоторговцев. Там рождаются с " +
                        "косяком в одной руке и с пушкой - в другой. И для того чтобы выбраться из " +
                        "этого ада, нет другого шанса, кроме совершения преступлений.", 5),
                RecyclerMoviesItem(R.drawable.night_school, "Вечерняя школа", "Группе бездельников придется " +
                        "пройти обучение в вечерней школе, чтобы получить, наконец, аттестат и найти " +
                        "нормальную работу", 6)
            )
        ) {listener?.onMoviesClick(it)}
    }

    companion object {
        const val TAG = "MovieListFragment"
    }

    interface OnMoviesClickListener {
        fun onMoviesClick(item:RecyclerMoviesItem)

    }
}