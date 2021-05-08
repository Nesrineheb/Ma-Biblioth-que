package com.example.exo2serie4

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var books = arrayOf<String>(
        "Frankenstein",
        "Foundation",
        "The Stars My Destination",
        "Solaris",
        "Dune",
        "Neuromancer",
        "Ice"
    )
    var books_authors = arrayOf<String>(
        "Mary Shelley (1818)",
        "Isaac Asimov (1951)",
        "Alfred Bester (1957)",
        "Stanislaw Lem (1961)",
        "Frank Herbert (1965)",
        "William Gibson (1984)",
        "Anna Kavan (1967)"
    )
    var books_description = arrayOf<String>(
        "Mary Shelley started writing classic gothic thriller Frankenstein when she was 18 years old. Two centuries later, it is a major ancestor of both the science fiction and horror genres, tackling huge themes like the nature of life and death, immortality and genetic engineering. It is a pro-science novel that at its heart shows Dr Frankenstein as the callous fiend of the story, who created a being and was not willing to accept responsibility for his actions. In an age where the space between technical life and death is narrower than ever, and scientists are playing with the makeup of what makes us humans, Frankenstein can still teach an important lesson: just because you can, doesn't mean you should.",
        "The Foundation series follows Hari Seldon, who is the architect of psychohistory – a branch of mathematics that can make accurate predictions thousands of years in advance, and which Seldon believes is necessary to save the human race from the dark ages. You can see why it’s one of Elon Musk’s favourite books (along with The Hitchhiker’s Guide to the Galaxy, and The Moon is A Harsh Mistress by Robert Heinlein – also recommended). A long-awaited screen adaptation is one of the flagship launch offering’s of Apple’s new streaming service.",
        "This landmark novel begins with a simple proposition – what if humans could teleport? – and sprawls into a tale of rebirth and vengeance that winds across the Solar System: The Count of Monte Cristo for the interstellar age. First published as Tiger! Tiger! in the UK, named after the William Blake poem, it follows Gully Foyle – a violent, uneducated brute who spends six months marooned in deep space, and the rest of the book seeking retribution for it.",
        "If you think you know Solaris from the 2002 Steven Soderbergh film, the original book may come as a bit of a surprise. Written by Polish writer Stanislaw Lem in 1961, this short novel is heavier on philosophy than plot. It follows a team of humans on a space station who are trying to understand the mysterious living ocean on the planet Solaris, with little success – their research is limited to lengthy descriptions that paint a vibrant picture of the alien planet but fail to elucidate how it works. As they poke and prod, Solaris ends up exposing more about them than it does about itself, with the book demonstrating the futility of humans trying to comprehend something not of their world.",
        "In 2012, WIRED US readers voted Dune the best science-fiction novel of all time. It’s also the best-selling of all time, and has inspired a mammoth universe, including 18 books set over 34,000 years and a terrible 1984 movie adaptation by David Lynch, his worst film by far. A hopefully better effort is currently in production, directed by Denis Villeneuve. The series is set 20,000 years in the future in galaxies stuck in the feudal ages, where computers are banned for religious reasons and noble families rule whole planets. We focus on the planet Arrakis, which holds a material used as a currency throughout the Universe for its rarity and mind-enhancing powers. Lots of giant sandworms, too.",
        "The definitive cyberpunk novel, William Gibson’s Neuromancer follows hacker-turned-junkie Henry Case as he tries to pull off one last, rather dodgy sounding job in the hope of reversing a toxin that prevents him from accessing cyberspace. Set in a dystopian Japanese underworld, the novel touches on all manner of futuristic technology, from AI to cryonics, and features a cast of creative characters that will stick with you long after you turn the last page.",
        "Anna Kavan's last (and best) sci fi novel provides a haunting, claustrophobic vision of the end of the world, where an unstoppable monolithic ice shelf is slowly engulfing the earth and killing everything in its wake. The male protagonist and narrator of the story (who is nameless) is eternally chasing after an elusive and ethereal young woman, while contemplating feelings that become darker and more violent towards her as the ice closes in. He frequently crosses paths with the Warden, the sometimes-husband but also captor of the young woman, who is always one step ahead. And as the ice closes off almost all paths by land and sea, he is running out of time to catch them up."
    )

    val adapter = BookAdapter(books, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.book_recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


    }
    override fun onClick(view: View) {
        if (view.tag != null) {
            val index = view.tag as Int
            val book = books[index]



            val orientation = resources.configuration.orientation
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                var titre = findViewById<TextView>(R.id.textView)
                var auteur = findViewById<TextView>(R.id.textView3)
                var description = findViewById<TextView>(R.id.textView4)

                titre.text =book
                auteur.text =books_authors[index]
                description.text=books_description[index]


            } else {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("titre", book)
                intent.putExtra("auteur", books_authors[index])
                intent.putExtra("description", books_description[index])
                startActivity(intent)
            }

        }
    }
}