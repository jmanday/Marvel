# Marvel

Repository which uses the Marvel API in order to show info about characters


## Architecture

This repository is formed by 4 modules.
- **core-data**: it's a android library which contains all common things related to datasources like dependencies to retrofit, room, third parties, etc.
- **core-ui**: it's a android library which contains all common things related to user interface like dependencies to activities, fragments, resources, third parties, etc.
- **core-domain**: it's a java library which contains the core for the bussiness logic.
- **app**: it's the android application module.



![Blank diagram - Page 5](https://user-images.githubusercontent.com/5518993/193853923-2691ba92-0dc7-44d8-aaf2-098380e2bf80.png)


## MVVM

Into **app** module, the **MVVM** architecure is implemented as the picture shows below.


![1*GVOEZQPu9MvGpn5nAsDKbQ](https://user-images.githubusercontent.com/5518993/194012626-d19dcd76-a3b7-4924-aaee-104910652dac.png)

- **View**: as the activity and fragments which will display the datas and catching user events.
- **ViewModel**: attached to the fragment lifecycle, it declares an user interface state and expose it through *StateFlow*
- **Repository**: which are injected into viewmodels and handle the bussiness logic and data transformation.
- **Data**: which contains the data sources where the data are sent/got from.


## Design 

- Just an activity and fragments using the **Navigation component** from **Jetpack**
- **Coroutines** and **StateFlow** in viewmodel layer.
- In **data** layer, using **retrofit** and **room** as datasources.
