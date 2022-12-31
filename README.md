# CALCULADORA SESIO
#### Video Demo:  <[URL HERE](https://youtube.com/shorts/cwJG_G-D6ME)>
#### Description: 

My project is a simple calculator, which has the basic functions (that can be divided, multiplied, added, subtracted, delete operations and numbers), but with a function that allows you to know what the value of a purchase will be in dollars abroad, in my country Argentina there are taxes established for purchases in dollars abroad, on digital platforms such as Steam, Amazon, Google Play Store, etc., for this reason it seemed very useful to have a calculator that allows you to know How much is the total amount of the purchase?

The first thing I started to define in my application are its functions, I needed: a function to __delete a character__, to __delete the operation__ (these 2 operations are contained in any modern calculator), and a __button that takes you to another view__ in which through an input of a value in dollars, the taxes that are added for a purchase outside of Argentina are calculated.
For the design (colors, shapes, buttons, etc.) look for references about calculator designs that nowadays we all have installed on our cell phones, then I designed a __top-down__ scheme in which I broke down my application into its different functions to be able to schematize it better.

<ins>activity_main.xml</ins>

In order to work more comfortably with the buttons I decided to put __Guidelines__ (vertical and horizontal), in this way we won't have a problem when it comes to accommodating the elements and keeping them aligned. I then bind the guidelines to the texviews and buttons, set the size of the __Textview__ by which the results are viewed, and increase the text size.
The next step was to make the buttons, I configured their size depending on the design that I had previously proposed, also located where the operations should go, the button to delete a character and the operation and to go to the next view where I perform tax calculation.

The next step was to establish the __OnClick__ methods to which I know it must respond each time a button is pressed, example: each time the number 0 is pressed, that number is written on the screen, and so on with the others, for the the operations decided that each time a button is pressed, be it divide, multiply, add or subtract, it stores a __symbol__(÷, x, + y -);
I did the same with the cleaning buttons (__C__ and __DELETE__), I assigned them an OnClick method, limpiarTv and delete, then to the __DOLAR__ button its method only goes to the Taxes view.
 
<ins>Main_Activity.java</ins>

Here I took care of the logical part of the calculator, using the id's that I had previously declared, I linked the view with the logic of my application; Create the variables that will store both numbers and the operation that you want to carry out, for the numbers I decided to use the Float type to also store numbers with commas and initialize them to 0. Here I also implement the OnClick methods that the buttons respond to, each time one of the numbers is pressed, it is asked if there was already something written in tvRes (the calculator screen), if there is, it is concatenated with the new number entered, otherwise the new number is added, for example in the method __"escribirCero"__ each time __0__ is pressed, that number is sent to __tvRes__, and so with the other methods that write numbers; To store the operation I decided to use a String since what is going to be saved are symbols of the operations, for example: each time the __sumar__ method is pressed, the __op__ variable is assigned the string __"+"__ and so with the others.

For the __limpiarTv__ (delete all) method: I assign to all the variables the __value 0__ and to the string op the __empty value__ (""), then I make the tvRes return to its __initial value__ (0), and in the case of Borrar (delete last character) was more complicated since I had to obtain the string of numbers and delete the last value, what I did was create an auxiliary variable called text which takes the value of all the current numbers on the screen (this is a sequence of values therefore is an array) and then I shorten the length of the array by 1, so I am __removing the last number entered__.

The next thing to do is the __Igual__ method in which I specify all the operations and apply that result to the tvRes. I found it more dynamic to use nested if's to ask about the value contained within the variable __op__ (-,+,x,÷) and __perform the operation__ between both numbers previously stored in their respective variables. In addition, here I also needed some way to round off the resulting number, for this I used the __BigDecimal__ class, it is a Java class to represent floating point numbers accurately.

The last step was to make the method for the __punto__ in which all it does is __concatenate the previous__ written in the tvRes with a dot (.) and the method to pass there the next view (Taxes) in which the __Intent__ object is used , an Intent is a messaging object that you can use to request an action from another component of an app.

<ins>activity_taxes.xml</ins>

As in the Main view prior to its implementation, I decided to make a top-down scheme about the functions that had to be implemented in Taxes, in Argentina we have __2 types of taxes__ that are applied to online purchases abroad, __Country Tax__ (Impuesto Pais) and __Tax on the Profits__ (Impuesto a las Ganancias), each one with its percentages of added values (that is to say: if we have a purchase of __10__ dollars, currently without taxes it would be __$1790__ pesos, the Country Tax (30%) of this purchase are: __$537__ and of the Tax on the Profits (45%) is: __$805.5__ pesos, the total of this purchase would be, in pesos, __$3132.5__) for this reason it seemed necessary to show these values when calculating a value, the value based on pesos, how much of both taxes are added and the total that would be invoiced.

To start create a button which allows you to __go back to Main__, and another button to __calculate__ the value of the dollars entered. Then create the __different textviews__ to display the corresponding values, as well as an EditText to enter the amount to be calculated.

<ins>Taxes.java</ins>

After linking the logic with the different views in which the amounts are displayed, make a method that __returns to Main__ also using the Intent class.
Then I made the method to which the __Calcular__ button responds, in which I established the current value of the dollar in Argentina, the percentage of Country Tax and Income Tax, then I obtain the value entered with et (EditText), the next step is carry out the calculations to know how much of each tax is added using the following formula ``(((Amount of dollars / 100) * percentage of the tax) * price of a Dollar))``, and then the total sum.

Finally I show the values in their corresponding __TextViews__.

<ins>Other Files<ins>

+ AndroidManifest.xml

     In this file, the only thing that I modified was the orientation of the views so that when the option to put the application horizontally is active it flips.

+ ic_Launcher
  
     I customize an icon for my app, which appears as the main logo and in the Main view.