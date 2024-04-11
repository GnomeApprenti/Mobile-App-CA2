Leith Chakroun - 74529


Requirements checklist : 

1. Movie screen:

1.1. Create a Movie class with the structure specified in movie.json - yes
1.2. Obtain and fill data (minimum of 4 movies) - yes
1.2.1. Obtain relevant movie data from Vue (https://www.myvue.com/cinema/dublin/whats-on) or your favourite provider and add data credits at the bottom of the app - yes 
1.2.2. Generate a random number between 0 and 15 for each movie and assign to seats_remaining - yes
1.2.3. Start with an initial default seats_selected value of 0 for all movies - yes 
1.2.4. You shall fill random URLs for images from pixabay or other free image providers to begin with - yes 
1.4. If any seats are selected, show how many seats are selected and hide remaining seats - yes
   
2. Seat selection feature:
   
2.1. Clicking any item (anywhere on the item) on the movie screen should open a new MovieActivity, refer to movie_activity_*.jpg - yes
2.2. Add plus and minus icons, show seats_selected in the middle - yes 
2.3. On click plus/minus, update both seats_selected and seats_remaining for that movie - yes 
2.4. Add validation, when 0 seats selected minus is disabled, when 0 seats remaining plus is disabled - yes
2.5. When back is pressed, the selected seats are retained and reflected in the screen. - yes

Report : 

For this assessment, after reading the requirements I identified that I needed to make at least two screens. One home screen and one movie screen. 
The two have to communicate data in order to display the right movie.

My first step was to create two basic screens and implement the navigator using routes as we have seen in class, which was pretty straightforward. 

The first challenge I faced was importing images from the internet. In order to do this I used the AsyncImage element from the coil library, which worked perfectly.
All images for the film banners were imported from wikipedia. 

The next challenge I faced was transferring data from the home screen to the movie screen to display the right movie. I achieved this by adding the movie name as an argument
in the route to the movie screen and then retrieving the rest of the movie data using it's name. 

The last challenge I faced was making was updating the number of available seats when the buttons were pressed. In order to make the text which displays this information dynamic,
I made the values of seats remaining and seats selected mutable, which worked perfectly.

To sum up, I faced three main challenges regarding the display of online images, transferring data when routing and the dynamic display of information on screen. Through research and
reading of the technologie's documentation, I was able to find solutions. 
