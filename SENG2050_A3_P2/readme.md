# SENG2050_A3
### Authors: Scott Lonsdale, Ben Perkins, and Bryce Tuppurainen

Please note the folder Generic, this will contain all of the styling standards and the default template for JSP (and other files) that will be used to create the final submission. Also note that this repo is not to be submitted, as the .gitignore, this readme.md and the generics (and possibly some other files) are not to be included in the final submission.

#### Standards

Please leave this section unchanged unless discussed with the team.

- All development notes are to be listed in this readme file rather than in commenting on any particular page to avoid acccidental submission and so that they're easier to find

- All .jsp are hidden from the front end and displayed by servlets in the final version of the project

- Only use PR reviewed by someone else to push to main in GitHub from a seperate branch (ensures work is reviewed by a teammate first)

- All images are stored as jpg in the /images directory. Name in lowercase, underscore seperation if necessary


    ##### Styles

    - CSS uses rgb() and rgba() for colors

    - All styling is external in styles.css in the root directory (no embedded or inline styling should be required)
    
    - styles.css is ordered by ascending priority of the tag (html is lowest, followed by body, top-level semantics (nav, footer main), block elements, inline elements, then finally classes and ID), they're then sorted alphabetically

    - If styling must be specific to an element, use a unique class attribute and add it to the bottom of the CSS rather than ID

    - Use a class attribute in the body to define the background image used for the page, this will be the name of the image followed by _background, e.g. newcastle_background

    - See generic.jsp for semantic tags standards


#### Development Notes

- Sections are used to create a 'tile' on the page with the CSS.

- All pages must display correctly on mobile devices, this is currently in the second bottom section of the css which automatically detects the viewport width and adjusts the page formatting accordingly

#### Color Palette (feel free to add on this)

rgb(0, 0, 0); Solid Black

rgb(255, 255, 255); Solid White

rgb(236, 196, 255); Pale Pink (Links and borders)

rgba(119, 119, 119, 0.65); Translucent Light Gray

rgba(0, 0, 0, 0.8); Translucent Black

#### Sources

https://www.newcastle.nsw.gov.au/home - newcastle.jpg source (the image is licenced as public domain)

https://www.newcastle.nsw.gov.au/city-hall/home - council_building.jpg source

https://commons.wikimedia.org/wiki/File:Newcastle_ANZAC_Walk.JPG - anzac_walk.jpg source (wikimedia public domain)