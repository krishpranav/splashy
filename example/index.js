import React, { Component } from "react";
import { StyleSheet, Text, View } from "react-native";
import splashy from "..";

export default class Index extends Component {
    state = {
        isLoading: true,
    };

    componentDidMount() {
        globalThis.setTimeout(() => {
            this.setState({ isLoading: false });
        }, 1000);
    }

    componentDidUpdate() {
        if (!this.state.isLoading) {
            splashy.hide();
        }
    }

    render() {
        if (this.state.isLoading) return null;

        return (
            <View style={styles.container}>
                <Text style={styles.welcome}>
                    Hello, World!
                </Text>
            </View>
        )
    }
}


const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
    },
    welcome: {
        fontSize: 20,
        textAlign: "center",
        margin: 10,
    },
});