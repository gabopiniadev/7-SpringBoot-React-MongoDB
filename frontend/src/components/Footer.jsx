import React from "react";
import Logo from "../img/R.png";

const Footer = () => {
  return (
    <footer>
      <img src={Logo} alt="" />
      <span>
        Hecho con <b>React.js</b>.
      </span>
    </footer>
  );
};

export default Footer;
