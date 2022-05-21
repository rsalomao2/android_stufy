package com.salomao.androidstury.models

class DataSorce {

    companion object {

        fun createDataSet(): ArrayList<References> {

            val list = ArrayList<References>()

            list.add(
                References(
                    "https://sm.ign.com/ign_br/screenshot/default/nezuko_vw8x.jpg",
                    "Nezuko",
                    "+11(11)00001-0001",
                    "001.001.001-01",
                    "nezuko@gmail.com",
                )
            )

            list.add(
                References(
                    "https://i.pinimg.com/736x/1d/4d/69/1d4d69c694c8ba1034c0e9552f457ecf.jpg",
                    "Stitch",
                    "+22(22)00002-0002",
                    "002.002.002-02",
                    "stitch@gmail.com",
                )
            )

            list.add(
                References(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQg8eIoPSTYSTB87mWRHL2bI-lNXNIu-Y2bcw&usqp=CAU",
                    "Tanjiro",
                    "+33(33)00003-0003",
                    "003.003.003-03",
                    "tanjiro@gmail.com",
                )
            )

            list.add(
                References(
                    "https://f.i.uol.com.br/fotografia/2021/02/18/1613671083602eaaabe3537_1613671083_3x2_md.jpg",
                    "Naruto",
                    "+44(44)00004-0004",
                    "004.004.004-04",
                    "naruto@gmail.com",
                )
            )

            list.add(
                References(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQukMkbIYE3OWePreGLDa_1-SqhiEjVbAXxHQ&usqp=CAU",
                    "Sasuke",
                    "+55(55)00005-005",
                    "005.005.005-05",
                    "Sasuke@gmail.com",
                )
            )

            list.add(
                References(
                    "https://i.pinimg.com/736x/e2/b6/15/e2b615e8bbd7a1b8655c9ab2b84ab6de.jpg",
                    "Levi",
                    "+66(66)00006-006",
                    "006.006.006-06",
                    "Levi@gmail.com",
                )
            )

            list.add(
                References(
                    "https://i.pinimg.com/474x/a8/0f/9e/a80f9e47e046bfb9e27b459f36acd66f.jpg",
                    "Eren",
                    "+77(77)00007-007",
                    "007.007.007-07",
                    "Eren@gmail.com",
                )
            )

            list.add(
                References(
                    "https://i.pinimg.com/564x/bb/33/6d/bb336d93c51d7d965aa4cbd8a3e973fe.jpg",
                    "Mikasa",
                    "+88(88)00008-008",
                    "008.008.008-08",
                    "Mikasa@gmail.com",
                )
            )


            list.add(
                References(
                    "https://i0.wp.com/oxentesensei.com.br/wp-content/uploads/2021/04/attack-on-titan-armin-01.jpg?resize=800%2C534&ssl=1",
                    "Ermin",
                    "+99(99)00009-009",
                    "009.009.009-09",
                    "Ermin@gmail.com",
                )
            )

            return list
        }
    }
}