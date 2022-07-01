import { StatusBar } from "expo-status-bar";
import React, { useState } from "react";
import { StyleSheet, Text, View, ScrollView, Image } from "react-native";
import CarItem from "../components/CarItem";
import empty from "../assets/empty.png";

export default function Home({ navigation }) {
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
    {
      name: "2022 Alfa Romeo Stelvio",
      model: " Alfa Romeo",
      description:
        "Third car description - Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
      brand:
        "https://seeklogo.com/images/A/alfa-romeo-logo-3E9AF560E2-seeklogo.com.png",
      image:
        "https://hips.hearstapps.com/hmg-prod/images/2022-alfa-romeo-stelvio-mmp-1-1635976036.jpg?crop=0.885xw:0.701xh;0.0705xw,0.154xh&resize=2048:*",
    },
    {
      name: "2022 Fiat 500X",
      model: "Fiat",
      description:
        "Here is the description of the Forth car, here we can have a longer text and it should be well aligned with the rest of the content",
      brand:
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Fiat_Automobiles_logo.svg/1200px-Fiat_Automobiles_logo.svg.png",
      image:
        "https://hips.hearstapps.com/hmg-prod/images/2022-fiat-500x-yacht-club-capri-special-edition-03-1638226732.jpg?crop=1.00xw:0.849xh;0,0.120xh&resize=2048:*",
    },
  ]);

  const removeCar = (index) => {
    const tempCars = [...cars];
    tempCars.splice(index, 1);
    setCars(tempCars);
  };

  return (
    <View style={styles.container}>
      <ScrollView showsVerticalScrollIndicator={false}>
        {cars.length > 0 ? (
          cars.map((car, index) => {
            return (
              <CarItem
                car={car}
                key={index}
                navigation={navigation}
                removeCar={removeCar}
              />
            );
          })
        ) : (
          <View style={styles.emptyWrapper}>
            <Image style={styles.emptyImage} source={empty} />
            <Text style={styles.emptyText}>No Cars Yet</Text>
          </View>
        )}

        <StatusBar style="auto" />
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
  },
  emptyWrapper: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    height: "100%",
    backgroundColor: "#fff",
  },
  emptyImage: {
    width: 290,
    height: 200,
    alignSelf: "center",
    marginBottom: 20,
    resizeMode: "contain",
  },
  emptyText: {
    fontSize: 20,
  },
});
