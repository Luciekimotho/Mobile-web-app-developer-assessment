# Mobile web app developer assessment
All participants are advised to attempt all questions and share their solution via git or any
other version control tool. The solution should be working on testing on the available
devices.
### 1. What’s the difference between an implicit and an explicit intent? Show using code Snippets.
In Implicit intents you do not specify the components to be called, just the activity.

`Intent i= new Intent(ACTION_VIEW,Uri.parse("http://www.intents.com"));`

In Explicit intents you specify the component for example switching to another activity in response to a user action

`Intent i = new Intent(this, MainActivity.Class);
startActivity(i);`

### 2. When should you use a Fragment, rather than an Activity? Create a sample fragment
and show how it can be used across your application.
When there is need to re-use of parts of the screen including views and event logic in different ways across different activities. Fragment are then used for the different layouts or tasks and the common layout put in the activity.

```
public class PatientsFragment extends Fragment {
   public PatientsFragment() {
       // Required empty public constructor
   }
@Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
       // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_patients, container, false);
   }
}

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       FragmentManager fragmentManager = getSupportFragmentManager();
       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

       PatientsFragment fragment = new PatientsFragment();
       fragmentTransaction.add(R.id.patients_fragment_layout, fragment);
       fragmentTransaction.commit();
   }
}

```
[PatientsFragment.java](https://github.com/Luciekimotho/Mobile-web-app-developer-assessment/blob/master/app/src/main/java/com/luciekimotho/intellisoft/PatientsFragment.java)

[MainActivity.java](https://github.com/Luciekimotho/Mobile-web-app-developer-assessment/blob/master/app/src/main/java/com/luciekimotho/intellisoft/MainActivity.java)

### 3. How would you create a multi-threaded Android app without using the Thread class?
Show using code examples.

### 4. How would you access data in a ContentProvider? Explain using code examples.

### 5. What is a BuildType in Gradle? And what can you use it for?
Used to define the build and packaging settings like signing configuration for a project. 
Debug is the build type that is used when we run the application from the IDE directly onto a device. A release is the build type that requires you to sign the APK for release. 
 
### 6. Prompt the user to give app permission to access the camera and internet.
```
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
   package="com.luciekimotho.intellisoft">

   <uses-permission android:name="android.permission.CAMERA"/>
   <uses-permission android:name="android.permission.INTERNET"/>
   
   <application
      //Content here
   </application>

</manifest>
```
[AndroidManifest.xml with Camera & Internet permissions](https://github.com/Luciekimotho/Mobile-web-app-developer-assessment/blob/master/app/src/main/AndroidManifest.xml)
### 7. Create a registration form that collects patient demographics (Names, Contacts, address and Next of kin details) and temporarily store it in the device.
[Code for Patients demographic java class](https://github.com/Luciekimotho/Mobile-web-app-developer-assessment/blob/master/app/src/main/java/com/luciekimotho/intellisoft/PatientsActivity.java)

[Code for Patients demographic XML](https://github.com/Luciekimotho/Mobile-web-app-developer-assessment/blob/master/app/src/main/res/layout/activity_patients.xml)

### 8. Create a proper mapped json file with the patient data in 7 above

### 9. Enable searching through the patient list using patient name.

### 10. Write a function that uploads and opens a document of type:- pdf and any image file type.

### 11. How do you ensure that your website design or web application is accessible and
user-friendly? Show using sketches and code examples that can be rendered on the UI.
Responsive designs to ensure mobile compatibility as more and more people use their mobile phones to access the Internet. In HTML5 the use of the meta tag, media queries and bootstrap row and columns 
```
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

```
@media(min-width:980px) and (max-width: 1199px) {
	
	header #mainmenu a{
	padding-left:5px;
	padding-right:5px;
	}
}
```

```
<div class="row">
    <div class="col-sm-4">
  	...
    </div>
    <div class="col-sm-4">
  	...
    </div>
    <div class="col-sm-4">
	...
    </div>
  </div>
  ```

Making navigation intuitive so that site visitors are able to find their way to the different categories in the site and back to the home page. Also limiting the number of menu items so that the menu is not overcrowded. Drop-down menus can be used in larges site with many sections and pages.
 ```
 <li class="menu-item-has-children"><a href="#">Portfolio</a>
       <ul class="sub-menu">
         <li><a href="">Portfolio 3</a></li>
         <li><a href="">Portfolio 1</a></li>
         <li><a href="">Portfolio 2</a></li>
       </ul>
</li>
```

### 12. What are your favorite features of HTML5, and how have you implemented them in your front end development projects in the past?
The new media and graphic elements that allow manipulation of multimedia and graphic elements. For example: 
```
<audio>, <video> and <canvas> 
``` 
Outlining and sectioning of elements using tags such as :
``` 
<section>, <header>, <footer>, <nav>, <aside> 
```

More form attributes such as validation using the required attribute:

```
 <form>
   <label for="choose">Would you prefer a web or mobile development?</label>
   <input id="choose" name="prefer" required>
   <button>Submit</button>
  </form>
```

### 13. How do you structure your CSS and JavaScript to make it easier for other developers to work with and access it in multiple files and projects? Show using sample files and
Structures.
Organizing the CSS and JS files with well commented sections for the different components. 
A hierarchical structure inline with how the components are used in the HTML file for example, starting with the header components, then the body components and finally the footer elements or having a key as to how the components are arranged in the stylesheet. 
```
* body
* header
	* subheader
* navigation
* content
* section
* footer

/* ================================================== */
/* body */
/* ================================================== */
html{
background:#000000 !important;
}

body {
	display:none;
	font-size: 15px;
	background:#606060;
	font-family: 'Roboto', sans-serif;
}
/* ================================================== */
/*  header	*/ 
/* ================================================== */
	header {
	width: 100%;
	height: 80px;
	}
/* ================================================== */
/* navigation */
/* ================================================== */
	#mainmenu {
	font-family:"Raleway", Arial, Helvetica, sans-serif;
	float: right;
	}
/* ================================================== */
/* contact form */
/* ================================================== */
	.form {
	padding:20px;
	border:none;
	display: none;
	color: #d9534f;
	
	}
/* ================================================== */
/* footer */
/* ================================================== */
footer {
	background: #111;
	color: #ccc;
	padding: 80px 0 0 0;
	}
 ```

### 14. What resources do you use to learn about the latest in front end development and design, and what is your understanding of principles of digital design?
I regularly read blogs and publications such on Medium and Flipboard such as the UX Collective and Muzli Design Inspiration.

I also visit CSS awards sites such as: https://www.cssdesignawards.com, https://www.awwwards.com and design portfolios to find out what other designers are working on and try to borrow some concepts in my own design.

### 15. Using angularJS or reactJS demonstrate Model View Controller framework. Use code
examples where necessary.

