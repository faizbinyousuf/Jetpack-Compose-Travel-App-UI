package com.example.travelapp.common.service

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class FireStoreService {


    private val db = Firebase.firestore

    // write data
    fun writeData(collectionName: String, data: Map<String, Any>) {
        db.collection(collectionName).add(data)
    }

    // read data
    fun readData(collectionName: String, documentId: String, callback: (Map<String, Any>?) -> Unit) {
        db.collection(collectionName).document(documentId)
            .get()
            .addOnSuccessListener { document ->
                callback(document.data)
            }
            .addOnFailureListener { exception ->
                callback(null)
            }
    }

    // update data
    fun updateData(collectionName: String, documentId: String, data: Map<String, Any>) {
        db.collection(collectionName).document(documentId)
            .update(data)
    }

    // delete data
    fun deleteData(collectionName: String, documentId: String) {
        db.collection(collectionName).document(documentId)
            .delete()
    }

    // real time listener
    fun addRealTimeListener(collectionName: String, documentId: String, callback: (Map<String, Any>?) -> Unit) {
        db.collection(collectionName).document(documentId)
            .addSnapshotListener { snapshot, _ ->
                callback(snapshot?.data)
            }
    }
}