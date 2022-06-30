import { StatusBar } from "expo-status-bar";
import React, { useState } from "react";
import { StyleSheet, Text, View, Image } from "react-native";

import Car from "./components/Car";

export default function App() {
  const [cars, setCars] = useState([
    {
      name: "Mercedes McLaren Artura",
      model: "Mercedes",
      description:
        "First Car Description - Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
      brand:
        "https://brandstruck.co/wp-content/uploads/2016/07/mercedes-logo-png.png",
      image:
        "https://mclaren.scene7.com/is/image/mclaren/Mclaren_Artura_Zenith%20Black_03:crop-16x9?wid=1980&hei=1114",
    },
    {
      name: "BMW X1",
      model: "BMW",
      description:
        "Second car description - Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
      brand:
        "https://thinkmarketingmagazine.com/wp-content/uploads/2012/08/bmw-logo.pngg",
      image:
        "https://hips.hearstapps.com/hmg-prod/images/p90465597-1654035021.jpeg?crop=0.863xw:0.729xh;0.101xw,0.186xh&resize=2048:*",
    },
  ]);

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Cars App</Text>
      {cars.map((car, index) => {
        return <Car car={car} key={index} />;
      })}
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
  },
  title: {
    width: 300,
    fontSize: 30,
    fontWeight: "bold",
    color: "white",
    padding: 10,
    backgroundColor: "#e75c3c",
    textAlign: "center",
    marginTop: 25,
  },
});
