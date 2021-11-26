<div id="top"></div>




<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/CSE4081-d-star-team/testCaseGenerator">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>


</br>

<h3 align="center">Map Generator</h3>

  <p align="center">
    Map generator for path finding algorithms with GUI
    <br />
    <br />
    <a href="https://github.com/CSE4081-d-star-team/testCaseGenerator">View Demo</a>
    ·
    <a href="https://github.com/CSE4081-d-star-team/testCaseGenerator/issues">Report Bug</a>
    ·
    <a href="https://github.com/CSE4081-d-star-team/testCaseGenerator/issues">Request Feature</a>
  </p>
</div>

</br>
</br>

<!-- ABOUT THE PROJECT -->
## About The Project

Have you ever wondered to have a map generator for your search algorithm inputs? This is the program!

There are currently 6 features implemented.

1. File directory path for output and input
2. Size of the greed field
3. Ramdom seed input field
4. Number of random obstacles field
5. Matrix generator
6. Map editor

When the map is generated, the grid file will be saved in txt file.
The file contatins 5 main char value.

'X' : Obstacle
'W' : Wall (Border)
'R' : Starting point
'G' : Goal
' ' : Empty cell

The location of astarting point will be fixed at the coordinate x:2, y:2
The location of a goal point will be fixed at the coordinate x: map_size - 2, y : map_size - 2
Therefore, the input grid size should be larger than 6.

<p align="right">(<a href="#top">back to top</a>)</p>
</br>

### Built With

* [Java JRE 15.0.1](https://www.java.com/en/)

</br>
</br>

<!-- GETTING STARTED -->
## How to run?

In oder to execute the program, please download the file by cloning this repository.

</br>

### Prerequisites

First, the java version checking is required.
A version of JRE 15.0.1 is required in order to run a jar file.
* In command prompt type
  ```sh
  java --version
  ```


<!-- USAGE EXAMPLES -->
## Usage

Can generate text-based map with required value fields. When you have to deal with multiple input cases for your own algorithm, use this! this will save your time!

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Marco Backman - roni2006@hanmail.net

Project Link: [https://github.com/TCC2021SeniorProject/ModelTranslator](https://github.com/CSE4081-d-star-team/testCaseGenerator)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/CSE4081-d-star-team/testCaseGenerator.svg?style=for-the-badge
[contributors-url]: https://github.com/CSE4081-d-star-team/testCaseGenerator/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/CSE4081-d-star-team/testCaseGenerator.svg?style=for-the-badge
[forks-url]: https://github.com/CSE4081-d-star-team/testCaseGenerator/network/members
[stars-shield]: https://img.shields.io/github/stars/CSE4081-d-star-team/testCaseGenerator.svg?style=for-the-badge
[stars-url]: https://github.com/CSE4081-d-star-team/testCaseGenerator/stargazers
[issues-shield]: https://img.shields.io/github/issues/CSE4081-d-star-team/testCaseGenerator.svg?style=for-the-badge
[issues-url]: https://github.com/CSE4081-d-star-team/testCaseGenerator/issues
