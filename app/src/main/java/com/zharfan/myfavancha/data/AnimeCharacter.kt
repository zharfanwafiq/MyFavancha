package com.zharfan.myfavancha.data

object AnimeCharacter {

    private val characterNames = arrayOf(
        "Naruto Uzumaki",
        "Yugi Mutou",
        "Monkey D. Luffy",
        "Saitama",
        "Ichigo Kurosaki",
        "Nobi Nobita",
        "Light Yagami",
        "Edward Elric",
        "Hinata Shoyo",
        "Izuku Midoriya",
        "Tanjiro Kamado"
    )

    private val characterPictures = arrayOf(
        "https://static.wikia.nocookie.net/naruto/images/d/dd/Naruto_Uzumaki%21%21.png",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiAIiGbku4P-rQ460wTZHUJw2lli-NClDj1eJw1xnoDcBr6HU4LPFZ_-k2l5YUqBMoMjY&usqp=CAU",
        "https://pbs.twimg.com/media/EXyMDB_UcAIs_-H.jpg",
        "https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2022/01/16/1035858770.png",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6hps7UpQOg-S6ixFbqDiipBHcnjS466ZoHA&usqp=CAU",
        "https://static.wikia.nocookie.net/doraemon/images/4/4c/Nobita_567c.jpg/revision/latest?cb=20190730015053&path-prefix=en",
        "https://static.wikia.nocookie.net/villains/images/5/54/Light_YagamiHD.jpg/revision/latest?cb=20180414020152",
        "https://static.wikia.nocookie.net/fma/images/0/08/213254_1407532169190_full.png/revision/latest?cb=20201016012253",
        "data:image/jpeg;base64,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",
        "https://www.greenscene.co.id/wp-content/uploads/2021/05/My-Hero-Academia-2-696x497.jpg",
        "https://thumb.suara.com/h-9TCipbzkomwQo4rnX__dLS6pc=/653x366/https://media.suara.com/pictures/653x366/2022/01/18/89156-karakter-tanjiro.jpg"
    )

    private val characterDescriptions = arrayOf(
        "Naruto Uzumaki yang bergelar Hokage Ketujuh adalah tokoh pendukung dari serial anime dan manga Naruto. Ia merupakan tokoh utama dalam serial ini. Ia digambarkan sebagai bocah berambut pirang dan bermata biru. Di pipinya ada semacam guratan yang mirip seperti kumis milik karakter Doraemon dalam manga Doraemon.",
        "Yugi Mutou adalah karakter fiksi yang diciptakan oleh Kazuki Takahashi dan merupakan karakter utama dari serial manga Yu-Gi-Oh!. Yugi diperkenalkan sebagai remaja yang memecahkan teka-teki Mesir kuno yang dikenal sebagai Teka-teki Milenium.",
        "Monkey D. Luffy adalah seorang karakter fiksi dan tokoh protagonis utama dalam serial anime dan manga One Piece karya Eiichiro Oda. Ia merupakan putra kandung dari pemimpin Pasukan Revolusioner, Monkey D. Dragon.",
        "Saitama merupakan sang tokoh super kuat sekaligus sang One Punch Man di dalam dunia yang penuh dengan superhero hebat tersebut.yang sekali tinju langsung mokad lawanya.",
        "Ichigo Kurosaki adalah karakter utama dari serial manga dan anime Bleach. Seri anime dan manga Bleach dimulai saat Ichigo menerima kekuatan shinigami karena bertemu dengan Rukia Kuchiki, seorang shinigami yang ditugaskan untuk mematroli Kota Karakura.",
        "Nobita Nobi, atau biasa dipanggil Nobita, adalah tokoh utama protagonis dalam cerita Doraemon. Ia adalah anak yang gagal sampai Doraemon datang dari abad ke-22 untuk membantunya sehingga ia bisa memiliki masa depan yang lebih baik dalam kehidupannya nanti.",
        "Light Yagami adalah protagonis dari serial manga Death Note, yang dibuat oleh Tsugumi Ohba dan Takeshi Obata.yang menggunakan buku terlarang untuk menyembelih manusia jahat.",
        "Edward Elric adalah karakter fiksi dan protagonis tituler dari seri manga Fullmetal Alchemist yang dibuat oleh Hiromu Arakawa. Edward, bergelar Fullmetal Alchemist, adalah State Alchemist termuda dalam sejarah negara fiksi Amestris.dia adalah seorang yang kangen dengan ibunya.",
        "Shoyo Hinata adalah karakter fiksi dan protagonis utama dari serial manga Haikyu!! dibuat oleh Haruichi Furudate. Shoyo adalah siswa SMA yang ingin menjadi seperti \"Raksasa Kecil\", mantan siswa SMA Karasuno dan anggota klub voli.",
        "Izuku Midoriya, juga dikenal dengan nama pahlawannya Deku, adalah seorang pahlawan super dan protagonis utama dari serial manga My Hero Academia, yang dibuat oleh Kōhei Horikoshi.",
        "Tanjiro Kamado adalah tokoh utama Demon Slayer: Kimetsu no Yaiba. Sebagai tokoh utama, sudah tentu dia memiliki deretan kemampuan luar biasa, yang membantu dia untuk mengatasi berbagai ancaman.yang memiliki sodara adalah seorang setan."

    )

    private val characterAges = arrayOf(
        27,
        18,
        19,
        25,
        17,
        10,
        23,
        18,
        16,
        16,
        15
    )

    val listData: ArrayList<Anime>
        get() {
            val list = arrayListOf<Anime>()
            for (position in characterNames.indices) {
                val anime = Anime()
                anime.characterName = characterNames[position]
                anime.characterPicture = characterPictures[position]
                anime.characterDescription = characterDescriptions[position]
                anime.characterAge= characterAges[position]
                list.add(anime)
            }
            return list
        }
}