package w3r.runsharing.entity;

import javax.persistence.*;
import java.time.Instant;
import lombok.Data;

@Data
@Entity
@Table(name="RunRecap")
public class RunRecap {

    /**
     * Meta Values
     */

    // Auto incrementing ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Wether or not this run expires
    @Column(name="permanent")
    private boolean permanent;

    // Time the run was uploaded
    @Column(name="uploaded_at")
    private Instant uploadedAt;

    /**
     * STS Values
     */

    // Player id
    @Column(name="host")
    private String host;

    // Played character
    @Column(name="character_chosen")
    private String characterChosen;

    // Chosen Node per Floor
    @Column(name="path_per_floor", length=65535, columnDefinition="Text")
    private String pathPerFloor;

    // Items bought from shops
    @Column(name="items_purchased", length=65535, columnDefinition="Text")
    private String itemsPurchased;

    // Amount of gold per floor
    @Column(name="gold_per_floor", length=65535, columnDefinition="Text")
    private String goldPerFloor;

    // Amount of campfires rested at
    @Column(name="campfire_rested")
    private int campfireRested;

    // Total floors reached
    @Column(name="floor_reached")
    private int floorReached;

    // Playtime of the run
    @Column(name="playtime")
    private long playtime;

    // Floors on which items where bought
    @Column(name="item_purchase_floors", length=65535, columnDefinition="Text")
    private String itemPurchaseFloors;

    // Current HP amount per floor
    @Column(name="current_hp_per_floor", length=65535, columnDefinition="Text")
    private String currentHpPerFloor;

    // Cards removed from deck
    @Column(name="items_purged", length=65535, columnDefinition="Text")
    private String itemsPurged;

    // Total gold at the end of the run
    @Column(name="gold")
    private int gold;

    // Wether or not the run was played with active ascension modifiers
    @Column(name="is_ascension_mode")
    private boolean isAscensionMode;

    // Wether or not the run was seeded
    @Column(name="chose_seed")
    private boolean choseSeed;

    // Amount of upgrades from campfires
    @Column(name="campfire_upgraded")
    private int campfireUpgraded;

    // Order of campfire choices
    @Column(name="campfire_choices", length=65535, columnDefinition="Text")
    private String campfireChoices;

    // Chosen Node per Floor
    @Column(name="path_taken", length=65535, columnDefinition="Text")
    private String pathTaken;

    // Amount of removes bought from shop
    @Column(name="purchased_purges")
    private int purchasedPurges;

    // Amount of circlet relics obtained, relevant for endless
    @Column(name="circlet_count")
    private int circletCount;

    // Player Deck
    @Column(name="master_deck", length=65535, columnDefinition="Text")
    private String masterDeck;

    // Max HP amount per floor
    @Column(name="max_hp_per_floor", length=65535, columnDefinition="Text")
    private String maxHpPerFloor;

    // If run was victorious
    @Column(name="victory")
    private boolean victory;

    // Relics at the end of the run
    @Column(name="relics", length=65535, columnDefinition="Text")
    private String relics;

    // Cards offered and cards selected
    @Column(name="card_choices", length=65535, columnDefinition="Text")
    private String cardChoices;

    // Potions used per floor
    @Column(name="potions_floor_usage", length=65535, columnDefinition="Text")
    private String potionsFloorUsage;

    // Damage taken per floor
    @Column(name="damage_taken", length=65535, columnDefinition="Text")
    private String damageTaken;

    // Relics obtained on floor
    @Column(name="relics_obtained", length=65535, columnDefinition="Text")
    private String relicsObtained;

    // Choices made in event nodes
    @Column(name="event_choices", length=65535, columnDefinition="Text")
    private String eventChoices;

    // Relics offered after Bosses
    @Column(name="boss_relics", length=65535, columnDefinition="Text")
    private String bossRelics;

    // Cards and Relics removed by floor
    @Column(name="items_purged_floor", length=65535, columnDefinition="Text")
    private String getItemsPurgedFloor;

    // Potions seen by floor
    @Column(name="potions_floor_spawned", length=65535, columnDefinition="Text")
    private String potionsFloorSpawned;

    // RNG Seed used
    @Column(name="seed_played")
    private long seed_played;

    // Potions taken by floor
    @Column(name="potions_obtained", length=65535, columnDefinition="Text")
    private String potionsObtained;

    // Ascension mode used
    @Column(name="ascension_level")
    private short ascensionLevel;
}
